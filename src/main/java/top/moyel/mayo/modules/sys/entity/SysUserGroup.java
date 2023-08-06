package top.moyel.mayo.modules.sys.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
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
@Table("sys_user_group")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysUserGroup extends BaseEntity {
    @Id
    private Long id;
    private String userGroupCode;
    private String userGroupDesc;
    private Integer status;
}
