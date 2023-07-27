package top.moyel.mayo.config;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * mybatis-plus 配置
 *
 * @author moyel
 */
@Configuration
@MapperScan("top.moyel.mayo.modules.*.mapper")
public class MpConfig {
    /**
     * mybatis plus 插件注册
     *
     * @return mybatis plus拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    @Bean(name = "mayoBaseEntityFillObjectHandler")
    public MetaObjectHandler mayoBaseEntityFillObjectHandler() {
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                long loginId = StpUtil.getLoginIdAsLong();
                this.strictInsertFill(metaObject, "createUser", Long.class, loginId);
                this.strictInsertFill(metaObject, "createTime", Date.class, DateUtil.date());
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                long loginId = StpUtil.getLoginIdAsLong();
                this.strictUpdateFill(metaObject, "updateUser", Long.class, loginId);
                this.strictUpdateFill(metaObject, "updateTime", Date.class, DateUtil.date());
            }
        };
    }
}
