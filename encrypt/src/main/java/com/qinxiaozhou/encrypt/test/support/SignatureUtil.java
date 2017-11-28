//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.qinxiaozhou.encrypt.test.support;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SignatureUtil {
    private static final String RSAAlgName = "RSA";
    private static final String DSAAlgName = "DSA";
    private SignType signType;

    public SignatureUtil(String algName) {
        assert algName.equalsIgnoreCase("RSA") || algName.equalsIgnoreCase("DSA");

        if (algName.equalsIgnoreCase("RSA")) {
            this.signType = SignType.RSA;
        } else if (algName.equalsIgnoreCase("DSA")) {
            this.signType = SignType.DSA;
        }

    }

    public SignatureUtil(SignType signType) {
        this.signType = signType;
    }

    public String sign(String text, String privateKeyData, String charset) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decode(privateKeyData));
        PrivateKey privateKey = KeyFactory.getInstance(this.signType.getName()).generatePrivate(keySpec);
        return this.sign(text, privateKey, charset);
    }

    public String sign(String text, PrivateKey privateKey, String charset) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, UnsupportedEncodingException {
        Signature signature = Signature.getInstance(this.signType.getSigAlg());
        signature.initSign(privateKey);
        signature.update(text.getBytes(charset));
        return Base64.encode(signature.sign());
    }

//    public String sign(RequestContent request, String key) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, UnsupportedEncodingException {
//        String content = request.sortContent();
//        String sign = null;
//        sign = this.sign(content, key, request.getCharset());
//        return request.genResult(this.signType.getName(), sign);
//    }
//
//    public boolean verify(RequestContent request, String key) throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, UnsupportedEncodingException {
//        Properties properties = request.getPropertiesByContent();
//        String verifyCharset = properties.getProperty("_input_charset");
//        if (StringUtil.isBlank(verifyCharset)) {
//            verifyCharset = request.getCharset();
//        }
//
//        String sign = StringEscapeUtil.unescapeURL(properties.getProperty("sign"), verifyCharset);
//        return this.verify(request.sortContent(), key, sign, verifyCharset);
//    }

    public boolean verify(String text, String publicKeyData, String sign, String charset) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.decode(publicKeyData));
        PublicKey publicKey = KeyFactory.getInstance(this.signType.getName()).generatePublic(keySpec);
        return this.verify(text, publicKey, sign, charset);
    }

    public boolean verify(String text, PublicKey publicKey, String sign, String charset) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        Signature signatureChecker = Signature.getInstance(this.signType.getSigAlg());
        signatureChecker.initVerify(publicKey);
        signatureChecker.update(text.getBytes(charset));
        return signatureChecker.verify(Base64.decode(sign));
    }

    public boolean verify(String text, Certificate cert, String sign) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature sig = Signature.getInstance(this.signType.getSigAlg());
        sig.initVerify(cert);
        sig.update(text.getBytes());
        return sig.verify(Base64.decode(sign));
    }
}
