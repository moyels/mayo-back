package top.moyel.mayo.modules.sys.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 更新角色的实体
 *
 * @author moyel
 */
@Data
public class SysRoleUpdateVO {
    @NotNull
    private Long id;
    private String roleName;
    private String roleCode;
    private Long parentRole;
    @Min(0)
    @Max(999)
    private Integer sortNo;
    private Boolean inherited;
}
