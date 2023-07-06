package top.moyel.mayo.modules.sys.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author moyel
 */
@Data
public class SysUserVO {
    private String username;
    private String nickname;
    private String email;
    private String phoneNumber;
    private Long sex;
    private String avatar;
    private Long status;
    private String loginIp;
    private Date loginDate;
}
