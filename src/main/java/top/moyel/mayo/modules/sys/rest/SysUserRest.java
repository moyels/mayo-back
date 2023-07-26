package top.moyel.mayo.modules.sys.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.moyel.mayo.constant.PageConstant;
import top.moyel.mayo.constant.ValidationConstant;
import top.moyel.mayo.modules.sys.entity.SysUser;
import top.moyel.mayo.modules.sys.mapstruct.SysUserMapStruct;
import top.moyel.mayo.modules.sys.service.ISysUserService;
import top.moyel.mayo.modules.sys.vo.SysUserSaveVO;
import top.moyel.mayo.modules.sys.vo.SysUserVO;

import javax.validation.constraints.NotBlank;
import java.util.Optional;


/**
 * @author moyel
 */
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/user")
public class SysUserRest {
    private final ISysUserService sysUserService;

    @GetMapping
    public SysUserVO fetch(@NotBlank(message = ValidationConstant.USERNAME_NOT_BLANK) String username) {
        MPJLambdaWrapper<SysUser> wrapper = new MPJLambdaWrapper<SysUser>()
                .selectAsClass(SysUser.class, SysUserVO.class)
                .eq(SysUser::getUsername, username);

        Optional<SysUserVO> sysUserOptional = Optional.ofNullable(sysUserService.selectJoinOne(SysUserVO.class, wrapper));
        return sysUserOptional.orElse(null);
    }

    @GetMapping("/page")
    public Page<SysUserVO> page(
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_STR) Integer page,
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_SIZE_STR) Integer pageSize
    ) {
        Page<SysUserVO> pageImpl = Page.of(page, pageSize);

        MPJLambdaWrapper<SysUser> wrapper = new MPJLambdaWrapper<SysUser>().selectAsClass(SysUser.class, SysUserVO.class);
        return sysUserService.selectJoinListPage(pageImpl, SysUserVO.class, wrapper);
    }

    @PostMapping
    public Boolean save(@Validated @RequestBody SysUserSaveVO sysUserSaveVO) {
        SysUser sysUser = SysUserMapStruct.INSTANCE.toSaveDTO(sysUserSaveVO);
        return sysUserService.save(sysUser);
    }

    @DeleteMapping("/{id}")
    public Boolean save(@PathVariable Long id) {
        return sysUserService.removeById(id);
    }

    @PutMapping
    public Boolean update(@Validated @RequestBody SysUserSaveVO sysUserSaveVO) {
        SysUser sysUser = SysUserMapStruct.INSTANCE.toSaveDTO(sysUserSaveVO);
        return sysUserService.lambdaUpdate().eq(SysUser::getUsername, sysUser.getUsername()).update(sysUser);
    }
}
