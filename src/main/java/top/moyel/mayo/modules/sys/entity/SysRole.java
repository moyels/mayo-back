package top.moyel.mayo.modules.sys.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
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
@Table(value = "sys_role")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {
    @Id(keyType = KeyType.Auto)
    private Long id;
    private String roleName;
    private String roleCode;
    private Long parentRole;
    private Integer sortNo;
    private Integer status;
    private Boolean inherited;
}
