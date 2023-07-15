package top.moyel.mayo;

import cn.hutool.core.util.TypeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.moyel.mayo.modules.sys.service.impl.SysUserServiceImpl;

import java.lang.reflect.Type;
import java.util.Arrays;

@SpringBootTest
class MayoBackApplicationTests {

    @Test
    void contextLoads() {
        Type[] typeArguments = TypeUtil.getTypeArguments(SysUserServiceImpl.class);
        System.out.println(Arrays.toString(typeArguments));
    }

}
