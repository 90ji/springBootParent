package com.qinxiaozhou.encrypt.test;


import com.qinxiaozhou.encrypt.test.support.KeyType;
import com.qinxiaozhou.encrypt.test.support.SignatureUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.*;

public class KeyTool {
    public KeyTool() {
    }

    public static String[] generateKey(KeyType keytype) throws Exception {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(keytype.getName());
        } catch (NoSuchAlgorithmException var7) {
            throw new Exception("不支持的算法名称：" + keytype.getName());
        }

        SecureRandom secureRandom = new SecureRandom();
        keyPairGenerator.initialize(keytype.getLength(), secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        String[] result = new String[]{Base64.encode(privateKey.getEncoded()), Base64.encode(publicKey.getEncoded())};
        return result;
    }

    public static boolean checkKey(KeyType keytype, String privateKeyData, String publicKeyData) throws InvalidKeyException, SignatureException, Exception {
        String text = "abcdefghijklmknopq";
        String sign = null;
        SignatureUtil sig = new SignatureUtil(keytype.getName());

        try {
            sign = sig.sign(text, privateKeyData, "UTF-8");
        } catch (InvalidKeyException var10) {
            throw new InvalidKeyException("私钥内容不正确：" + var10.getMessage());
        } catch (SignatureException var11) {
            throw var11;
        } catch (Exception var12) {
            throw new Exception("私钥内容不正确：" + var12.getMessage());
        }

        try {
            return sig.verify(text, publicKeyData, sign, "UTF-8");
        } catch (InvalidKeyException var7) {
            throw new InvalidKeyException("公钥内容不正确：" + var7.getMessage());
        } catch (SignatureException var8) {
            throw var8;
        } catch (Exception var9) {
            throw new Exception("公钥内容不正确：" + var9.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {

        KeyType keyType = KeyType.RSA2048;
        String privateKey = null;
        String publicKey = null;
        try {
            String[] result = KeyTool.generateKey(keyType);
            if ((result == null) || (result.length != 2)) {
                System.out.println("生成密钥失败!\n");
            }
            privateKey = result[0];
            publicKey = result[1];
            System.out.println("privateKey:" + result[0] + "\n");
            System.out.println("publicKey:" + result[1] + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean b = checkKey(keyType, privateKey, publicKey);
        System.out.println("检验结果:"+b);
    }
}