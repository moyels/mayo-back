package top.moyel.mayo.modules.sys.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import top.moyel.mayo.constant.ValidationConstant;

import javax.validation.constraints.NotBlank;

/**
 * 登录 VO
 *
 * @author moyel
 */
@Data
public class SysLoginVO {
    @NotBlank(message = ValidationConstant.USERNAME_NOT_BLANK)
    @Length(min = 5, max = 20, message = ValidationConstant.USERNAME_LEN)
    private String username;
    @NotBlank(message = ValidationConstant.PASSWORD_NOT_BLANK)
    private String password;
    private String captcha;
}
