package top.moyel.mayo.modules.sys.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import top.moyel.mayo.constant.ValidationConstant;

import javax.validation.constraints.NotBlank;

/**
 * @author moyel
 */
@Data
public class SysUserSaveVO {
    @NotBlank(message = ValidationConstant.USERNAME_NOT_BLANK)
    @Length(min = 5, max = 20, message = ValidationConstant.USERNAME_LEN)
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String phoneNumber;
    private Long sex;
}
