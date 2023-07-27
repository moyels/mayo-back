package top.moyel.mayo.modules.sys.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 用户组更新VO
 *
 * @author moyel
 */
@Data
public class SysUserGroupUpdateVO {
    @NotNull
    private Long id;
    private String userGroupCode;
    @Length(max = 127, message = "描述长度过长")
    private String userGroupDesc;
}
