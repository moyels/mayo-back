package top.moyel.mayo.modules.sys.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.moyel.mayo.config.BaseEntity;

import java.util.Date;

/**
 * @author moyel
 */
@Data
@Table(value = "sys_user")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String phoneNumber;
    private Long sex;
    private String avatar;
    private String password;
    private String salt;
    private Long status;
    private String loginIp;
    private Date loginDate;
}
