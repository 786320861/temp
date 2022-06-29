package com.example.chengdudemo;

/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

/**
 * @author piwei.pw
 * @version 0, 1: AlipayConfig.java, v 0.1 2020年12月10日 下午7:20 piwei.pw Exp $
 */

@EnableAutoConfiguration
@Component
public class AlipayConfig {

    private AlipayClient alipayClient = null;

    /**
     * 支付宝开放平台appId
     */
    @Value("${alipay.appId}")
    private String       appId;
    /**
     * 商户应用私钥，用于对发送给支付宝的信息进行加签
     */
    @Value("${alipay.merchantPrivateKey}")
    private String       merchantPrivateKey;

    /**
     * 支付宝分配的公钥，用于验证支付宝返回的信息。
     */
    @Value("${alipay.alipayPublicKey}")
    private String alipayPublicKey;


    /**
     * 签名类型RSA2一般使用
     */
    @Value("${alipay.signType}")
    private String signType;

    /**
     * 支付宝网关地址
     */
    @Value("${alipay.gatewayHost}")
    private String gatewayHost;

    /**
     * 请求格式
     */
    @Value("${alipay.format}")
    private String format;

    /**
     * 字符编码
     */
    @Value("${alipay.charset}")
    private String charset;

    /**
     * 通信协议
     */
    @Value("${alipay.protocol}")
    private String protocol;


    public AlipayClient getAlipayClient() {
        if (alipayClient == null) {
            alipayClient = new DefaultAlipayClient(
                    gatewayHost,
                    appId,
                    merchantPrivateKey,
                    format,
                    charset,
                    alipayPublicKey,
                    signType);
        }
        return alipayClient;
    }

}