package top.moyel.mayo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.moyel.mayo.entity.BaseEntity;

import java.util.Date;

/**
 * @author moyel
 */
@Data
@ToString(callSuper = true)
@TableName(value = "sys_user")
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {
    @TableId
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
