package top.moyel.mayo.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.moyel.mayo.entity.BaseEntity;

/**
 * 角色
 *
 * @author moyel
 */
@Data
@TableName(value = "sys_role")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {
    @TableId
    private Long id;
    private String roleName;
    private String roleCode;
    private Long parentRole;
    private Integer sortNo;
    private Integer status;
    private Boolean inherited;
}
