package top.moyel.mayo.modules.sys.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 保存角色的VO
 *
 * @author moyel
 */
@Data
public class SysRoleSaveVO {
    @NotBlank
    private String roleName;
    @NotBlank
    private String roleCode;
    private Long parentRole;
    @NotNull
    @Min(0)
    @Max(999)
    private Integer sortNo;
    private Boolean inherited;
}
