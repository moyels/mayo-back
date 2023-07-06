package top.moyel.mayo.config;

import com.mybatisflex.annotation.AbstractUpdateListener;

/**
 * @author moyel
 */
public class MpFlexUpdateListener extends AbstractUpdateListener<BaseEntity> {
    @Override
    public Class<BaseEntity> supportType() {
        return BaseEntity.class;
    }

    @Override
    public void doUpdate(BaseEntity baseEntity) {
        baseEntity.setUpdateUser(1L);
    }
}
