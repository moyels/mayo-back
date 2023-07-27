package top.moyel.mayo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户组和角色的关联表
 *
 * @author moyel
 */
@Data
@TableName("sys_user_group_role")
public class SysUserGroupRole {
    @TableId
    private Long id;
    private Long userGroupId;
    private Long roleId;
}
