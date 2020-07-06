package org.chenguoyu.springcloud.security.util;

import org.junit.Test;

/**
  * 
  * @author 陈国钰 on 2020-7-6.
  * @version 1.0
  */
public class RsaUtilsTest {

    private String privateFilePath = "D:\\auth_key\\id_key_rsa";
    private String publicFilePath = "D:\\auth_key\\id_key_rsa.pub";

    @Test
    public void generateKey() throws Exception {
        RsaUtils.generateKey(publicFilePath, privateFilePath, "chenguoyu", 2048);
    }

    @Test
    public void getPublicKey() throws Exception {
        System.out.println(RsaUtils.getPublicKey(publicFilePath));
    }

    @Test
    public void getPrivateKey() throws Exception {
        System.out.println(RsaUtils.getPrivateKey(privateFilePath));
    }
}