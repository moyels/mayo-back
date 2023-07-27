package top.moyel.mayo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @author moyel
 */
@Data
public abstract class BaseEntity {
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Long updateUser;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
    private Integer deleted;
}
