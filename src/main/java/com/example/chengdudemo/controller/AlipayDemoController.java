/*
 * Ant Group
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.example.chengdudemo.controller;

import com.example.chengdudemo.manager.MiniManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author virgo
 * @version AlipayDemoController.java, v 0.1 2022年06月29日 00:08 virgo
 */
@RestController
public class AlipayDemoController {

    @Autowired
    private MiniManager miniManager;

    @RequestMapping(value = "/submitAudit", method = RequestMethod.GET)
    public String submitAudit(HttpServletRequest servletRequest) {
        return miniManager.submitAudit();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(HttpServletRequest servletRequest) {
        return miniManager.upload();
    }

    @RequestMapping(value = "/offline", method = RequestMethod.GET)
    public String offline(HttpServletRequest servletRequest) {
        return miniManager.offLine();
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(HttpServletRequest servletRequest) {
        return miniManager.query();
    }


    @RequestMapping(value = "/qrcode", method = RequestMethod.GET)
    public String qrCode(HttpServletRequest servletRequest) {
        return miniManager.qrCode();
    }
}