/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.example.chengdudemo.manager;

import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.example.chengdudemo.AlipayConfig;
import org.springframework.stereotype.Component;
import com.alipay.api.AlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.internal.util.file.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;

/**
 * @author virgo
 * @version MiniManagerImpl.java, v 0.1 2022年06月29日 00:10 virgo
 */
@Component
public class MiniManagerImpl implements MiniManager {
    @Autowired
    private AlipayConfig alipayConfig;

    @Override
    public String submitAudit() {
        AlipayClient alipayClient = alipayConfig.getAlipayClient();

        AlipayOpenMiniVersionAuditApplyRequest request = new AlipayOpenMiniVersionAuditApplyRequest();
        request.setLicenseName("license_name");
        request.setLicenseValidDate("9999-12-31");
        FileItem AppLogo = new FileItem("logo.png", getImageContent(
                "https://appstoreisvpic.alipayobjects.com/prod/1005396e-4598-4030-8fd4-81770937e5e4.png"));
        request.setAppLogo(AppLogo);
        request.setAppVersion("1.1.6");
        request.setAppSlogan("开发者日小程序测试");

        request.setMiniCategoryIds("XS1005_XS2041_XS3051");
        request.setAppDesc("这是一个小程序的描述这是一个小程序的描述这是一个小程序的描述这是一个小程序的描述");
        request.setServiceEmail("example@mail.com");
        request.setRegionType("GLOBAL");
        request.setVersionDesc("小程序版本描述小程序版本描述小程序版本描述小程序版本描述小程序版本描述小程序版本描述");
        request.setMemo("小程序示例");
        request.setAuditRule("BASE_PROMOTE");
        request.setBundleId("com.alipay.alipaywallet");
        request.setFirstScreenShot(AppLogo);
        request.setSecondScreenShot(AppLogo);
        request.setAutoOnline("true");
        try {
            AlipayOpenMiniVersionAuditApplyResponse response = alipayClient
                    .execute(request, null, "202206BBaa01292e23e744d280df1433712baX48");
            return response.getSubMsg();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String upload() {
        AlipayClient alipayClient = alipayConfig.getAlipayClient();

        AlipayOpenMiniVersionUploadRequest request = new AlipayOpenMiniVersionUploadRequest();

        request.setBizContent(
                "{" + "\"template_version\":\"0.0.2\"," + "\"template_id\":\"2021003132695159\","
                + "\"app_version\":\"1.1.6\","
                + "\"ext\":\"{\\\"extEnable\\\": true, \\\"ext\\\": {\\\"name\\\": \\\"leslie\\\"},\\\"window\\\": {\\\"defaultTitle\\\": \\\"AI2\\\"}}\","
                + "\"bundle_id\":\"com.alipay.alipaywallet\"" + "  }");
        try {
            AlipayOpenMiniVersionUploadResponse response = alipayClient
                    .execute(request, null, "202206BBaa01292e23e744d280df1433712baX48");
            return response.getSubMsg();
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String offLine() {
        AlipayClient alipayClient = alipayConfig.getAlipayClient();

        AlipayOpenMiniVersionOfflineRequest request = new AlipayOpenMiniVersionOfflineRequest();
        request.setBizContent(
                "{" + "\"app_version\":\"1.1.5\"," + "\"bundle_id\":\"com.alipay.alipaywallet\""
                + "  }");
        try {
            AlipayOpenMiniVersionOfflineResponse response = alipayClient
                    .execute(request, null, "202206BBaa01292e23e744d280df1433712baX48");
            return response.getSubMsg();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String query() {
        AlipayClient alipayClient = alipayConfig.getAlipayClient();

        AlipayOpenMiniVersionDetailQueryRequest request = new AlipayOpenMiniVersionDetailQueryRequest();
        request.setBizContent( "{" + "\"app_version\":\"1.1.6\"," + "\"bundle_id\":\"com.alipay.alipaywallet\""
                               + "  }");
        try {
            AlipayOpenMiniVersionDetailQueryResponse response = alipayClient
                    .execute(request, null, "202206BBaa01292e23e744d280df1433712baX48");
            return response.getStatus();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String qrCode() {
        AlipayClient alipayClient = alipayConfig.getAlipayClient();

        AlipayOpenAppQrcodeCreateRequest request = new AlipayOpenAppQrcodeCreateRequest();
        request.setBizContent(
                "{" + "  \"url_param\":\"pages/index/index\"," + "  \"query_param\":\"x=1\","
                + "  \"describe\":\"我是一个实例化小程序二维码\"," + "}");
        try {
            AlipayOpenAppQrcodeCreateResponse response = alipayClient
                    .execute(request, null, "202206BBaa01292e23e744d280df1433712baX48");
            return response.getQrCodeUrlCircleBlue();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static byte[] getImageContent(String url) {
        InputStream inputStream = null;
        try {
            URL imageUrl = new URL(url);
            inputStream = imageUrl.openStream();
            return IOUtils.toByteArray(inputStream);
        } catch (Exception e) {
            return null;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }
}