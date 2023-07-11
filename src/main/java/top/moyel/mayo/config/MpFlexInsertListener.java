package top.moyel.mayo.config;

import com.mybatisflex.annotation.AbstractInsertListener;
import top.moyel.mayo.entity.BaseEntity;

/**
 * @author moyel
 */
public class MpFlexInsertListener extends AbstractInsertListener<BaseEntity> {
    @Override
    public Class<BaseEntity> supportType() {
        return BaseEntity.class;
    }

    @Override
    public void doInsert(BaseEntity baseEntity) {
        baseEntity.setCreateUser(1L);
    }
}
