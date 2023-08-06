package top.moyel.mayo.entity;

import com.mybatisflex.annotation.Column;
import lombok.Data;

import java.util.Date;

/**
 * @author moyel
 */
@Data
public abstract class BaseEntity {
    private Long createUser;
    @Column(onInsertValue = "now()")
    private Date createTime;
    private Long updateUser;
    @Column(onUpdateValue = "now()")
    private Date updateTime;
    @Column(isLogicDelete = true)
    private Integer deleted;
}
