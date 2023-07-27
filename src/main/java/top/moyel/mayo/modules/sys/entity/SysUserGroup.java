package top.moyel.mayo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.moyel.mayo.entity.BaseEntity;

/**
 * 用户组
 *
 * @author moyel
 */
@Data
@ToString(callSuper = true)
@TableName("sys_user_group")
@EqualsAndHashCode(callSuper = true)
public class SysUserGroup extends BaseEntity {
    @TableId
    private Long id;
    private String userGroupCode;
    private String userGroupDesc;
    private Integer status;
}
