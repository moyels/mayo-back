package top.moyel.mayo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author moyel
 */
@Configuration
@MapperScan("top.moyel.mayo.modules.*.mapper")
public class MybatisFlexConfig {
}
