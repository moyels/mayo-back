package top.moyel.mayo.modules.sys.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * 用户组显示在页面上的内容
 *
 * @author moyel
 */
@Data
public class SysUserGroupVO {
    @Null
    private Long id;
    @NotBlank(message = "code必填")
    private String userGroupCode;
    @NotBlank
    @Length(max = 127, message = "描述长度过长")
    private String userGroupDesc;
}
