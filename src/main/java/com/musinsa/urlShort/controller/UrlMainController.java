package com.musinsa.urlShort.controller;

import com.musinsa.common.utility.ObjectUtility;
import com.musinsa.urlShort.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UrlMainController {
    private final UrlService urlService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(Model model) {
        return "/index";
    }

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public String urlChkPage(@PathVariable String shortUrl, Model model) {
        String originUrl = this.urlService.getOriginUrl(shortUrl);

        if(ObjectUtility.isNotEmpty(originUrl)) {
            return "redirect:" + originUrl;
        }

        if( shortUrl.contains("index")) {
            return "/index";
        }

        return "/noUrl";
    }

    @RequestMapping(value = "favicon.ico", method = RequestMethod.GET)
    @ResponseBody
    void returnNoFavicon() {
    }

}