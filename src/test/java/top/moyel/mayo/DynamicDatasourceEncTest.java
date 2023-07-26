package top.moyel.mayo;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import org.junit.jupiter.api.Test;

public class DynamicDatasourceEncTest {
    @Test
    public void genEncContent() {
        RSA rsa = SecureUtil.rsa();
        System.out.println("publicKey:" + rsa.getPublicKeyBase64());
        System.out.println("privateKey:" + rsa.getPrivateKeyBase64());

        String url = rsa.encryptBase64("jdbc:mariadb://127.0.0.1:3306/ink_mark", KeyType.PrivateKey);
        String user = rsa.encryptBase64("root", KeyType.PrivateKey);
        String password = rsa.encryptBase64("root", KeyType.PrivateKey);

        System.out.println("url:" + url);
        System.out.println("user: " + user);
        System.out.println("password:" + password);
    }
}
