package com.ddc.server.shiro;

import java.util.UUID;

import com.ddc.server.entity.DDCAdmin;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
/**
 * 工具类
 * @author dingpengfei
 */
/*
* 采用用户名密码 salt组合加密 采用的加密算法是md5.可以采用 Passwordutils工具类
*  注意创建用户时生成的密码必须与shiro配置里密码的加密算法以及散列次数保持一致 。
* */
public class PasswordUtils {

    public static final String ALGORITHM_NAME = "MD5";
    public static final Integer HASH_ITERATIONS = 2;

    public static void entryptPassword(DDCAdmin admin) {
        String salt = admin.getName()+"_"+UUID.randomUUID().toString();
        String temPassword = admin.getPassword();
        Object md5Password = new SimpleHash(ALGORITHM_NAME, temPassword, ByteSource.Util.bytes(salt), HASH_ITERATIONS);
        admin.setSalt(salt);
        admin.setPassword(md5Password.toString());
    }

}