package top.moyel.mayo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.moyel.mayo.modules.sys.entity.SysRole;

/**
 * @author moyel
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysRoleDTO extends SysRole {
    private String createUsername;
    private String createNickname;
    private String updateUsername;
    private String updateNickname;
}
