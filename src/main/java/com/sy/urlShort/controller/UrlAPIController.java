package com.sy.urlShort.controller;

import com.sy.urlShort.model.UrlDetailReqVo;
import com.sy.urlShort.model.UrlInfoVo;
import com.sy.urlShort.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/api/url")
@Slf4j
@RequiredArgsConstructor
public class UrlAPIController {
    private final UrlService urlService;

    private static final String URL_PREFIX = "http://localhost:8080/";

    @PostMapping("/getUrlList.do")
    @ResponseBody
    public List<UrlInfoVo> getUrlInfo() {
        return urlService.getUrlList();
    }

    @PostMapping(value = "/createShortUrl.do")
    @ResponseBody
    public UrlInfoVo createShortUrl(@RequestBody UrlDetailReqVo reqVo) throws UnsupportedEncodingException {
        UrlInfoVo resVo = new UrlInfoVo();
        String shortUrl = urlService.createShortUrl(reqVo);

        resVo.setOriginUrl(reqVo.getOriginUrl());
        resVo.setShortUrl(URL_PREFIX + shortUrl);

        return resVo;
    }
}