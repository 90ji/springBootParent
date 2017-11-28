package com.qinxiaozhou.encrypt.test.support;

/**
 * Create by qxz on 2017/11/15
 * Description:
 */

public class SignType {
    public static final SignType MD5 = new SignType("MD5", "MD5");
    public static final SignType DSA = new SignType("DSA", "SHA1withDSA");
    public static final SignType DSA_DOTNET = new SignType("DSA_DOTNET", "SHA1withDSA");
    public static final SignType RSA = new SignType("RSA", "SHA1withRSA");
    private final String name;
    private final String sigAlg;

    private SignType(String name, String sigAlg) {
        this.name = name;
        this.sigAlg = sigAlg;
    }

    public String getName() {
        return this.name;
    }

    public String getSigAlg() {
        return this.sigAlg;
    }
}
