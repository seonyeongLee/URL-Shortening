package com.musinsa.urlShort.controller;

import com.musinsa.urlShort.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UrlAPIController {
    @Autowired
    private UrlService urlService;

    @GetMapping("/url/getUrlInfo")
    public List<Map<String, Object>> getUrlInfo() {
        return urlService.getUrlInfo();
    }
}