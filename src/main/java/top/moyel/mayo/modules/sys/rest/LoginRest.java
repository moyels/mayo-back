package top.moyel.mayo.modules.sys.rest;

import cn.dev33.satoken.stp.StpUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.moyel.mayo.constant.TipsConstant;
import top.moyel.mayo.modules.sys.entity.SysUser;
import top.moyel.mayo.modules.sys.service.ISysUserService;
import top.moyel.mayo.modules.sys.vo.SysLoginVO;

import java.util.Optional;

/**
 * 系统管理/登录相关
 *
 * @author moyel
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class LoginRest {
    private final ISysUserService sysUserService;

    /**
     * 登录接口
     *
     * @param sysLoginVO 登录VO
     * @return 登录token
     */
    @PostMapping("/login")
    public String login(@Validated @RequestBody SysLoginVO sysLoginVO) {
        Optional<SysUser> sysUserOptional = sysUserService.lambdaQuery().eq(SysUser::getUsername, sysLoginVO.getUsername()).oneOpt();

        if (!sysUserOptional.isPresent()) {
            throw new RuntimeException(TipsConstant.USER_NOT_FOUND_TIPS);
        }

        SysUser sysUser = sysUserOptional.get();
        Long userId = sysUser.getId();
        StpUtil.login(userId);

        return StpUtil.getTokenValue();
    }

    /**
     * 登出接口
     *
     * @return 是否成功
     */
    @DeleteMapping("/logout")
    public Boolean logout() {
        StpUtil.logout();
        return true;
    }
}
