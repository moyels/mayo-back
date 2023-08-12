package top.moyel.mayo.modules.sys.rest;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
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

import static top.moyel.mayo.modules.sys.entity.table.SysUserTableDef.SYS_USER;


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
        Optional<SysUserVO> sysUserOptional = sysUserService.queryChain()
                .from(SYS_USER)
                .where(SYS_USER.USERNAME.eq(username))
                .oneAsOpt(SysUserVO.class);

        return sysUserOptional.orElse(null);
    }

    @GetMapping("/page")
    public Page<SysUserVO> page(
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_STR) Integer page,
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_SIZE_STR) Integer pageSize
    ) {
        Page<SysUserVO> pageImpl = com.mybatisflex.core.paginate.Page.of(page, pageSize);
        return sysUserService.pageAs(pageImpl, QueryWrapper.create(), SysUserVO.class);
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
        return sysUserService.update(sysUser, SYS_USER.USERNAME.eq(sysUser.getUsername()));
    }
}
