package top.moyel.mayo.modules.sys.rest;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.moyel.mayo.constant.PageConstant;
import top.moyel.mayo.constant.ValidationConstant;
import top.moyel.mayo.modules.sys.service.ISysUserService;
import top.moyel.mayo.modules.sys.vo.SysUserVO;

import javax.validation.constraints.NotBlank;

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
        QueryWrapper wrapper = QueryWrapper.create().from(SYS_USER).where(SYS_USER.USERNAME.eq(username));
        return sysUserService.getOneAsOpt(wrapper, SysUserVO.class).orElse(null);
    }

    @GetMapping("/page")
    public Page<SysUserVO> page(
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_STR) Integer page,
            @RequestParam(defaultValue = PageConstant.DEFAULT_PAGE_SIZE_STR) Integer pageSize
    ) {
        Page<SysUserVO> pageImpl = Page.of(page, pageSize);
        return sysUserService.pageAs(pageImpl, QueryWrapper.create(), SysUserVO.class);
    }

    @GetMapping("/test")
    public void testVoidParameter() {
    }
}
