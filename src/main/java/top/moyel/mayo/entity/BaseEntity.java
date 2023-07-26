package top.moyel.mayo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author moyel
 */
@Data
public abstract class BaseEntity {
    private Long createUser;
    private Date createTime;
    private Long updateUser;
    private Date updateTime;
    private Integer deleted;
}
