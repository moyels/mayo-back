package top.moyel.mayo.modules.sys.rest;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.moyel.mayo.constant.PageConstant;
import top.moyel.mayo.modules.sys.entity.SysUser;
import top.moyel.mayo.modules.sys.mapstruct.SysUserMapStruct;
import top.moyel.mayo.modules.sys.service.ISysUserService;
import top.moyel.mayo.modules.sys.vo.SysUserVO;

import java.util.Optional;

import static top.moyel.mayo.modules.sys.entity.table.SysUserTableDef.SYS_USER;


/**
 * @author moyel
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sys/user")
public class SysUserRest {
    private final ISysUserService sysUserService;

    @GetMapping
    public SysUserVO fetch() {
        Optional<SysUser> sysUserOptional = sysUserService.getOneOpt(SYS_USER.ID.eq(1L));
        return SysUserMapStruct.INSTANCE.toVO(sysUserOptional.orElse(null));
    }

    @GetMapping("/page")
    public Page<SysUserVO> page(
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_STR) Integer page,
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_SIZE_STR) Integer pageSize
    ) {
        Page<SysUserVO> pageImpl = Page.of(page, pageSize);
        return sysUserService.pageAs(pageImpl, QueryWrapper.create(), SysUserVO.class);
    }
}
