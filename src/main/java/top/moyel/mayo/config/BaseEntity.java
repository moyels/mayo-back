package top.moyel.mayo.config;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Date;

/**
 * @author moyel
 */
@Data
@Table(value = "base_entity", onInsert = MpFlexInsertListener.class, onUpdate = MpFlexUpdateListener.class, mapperGenerateEnable = false)
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
