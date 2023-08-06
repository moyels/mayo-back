package top.moyel.mayo.modules.sys.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * 用户组和角色的关联表
 *
 * @author moyel
 */
@Data
@Table("sys_user_group_role")
public class SysUserGroupRole {
    @Id
    private Long id;
    private Long userGroupId;
    private Long roleId;
}
