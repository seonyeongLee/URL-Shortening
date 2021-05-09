package com.musinsa.urlShort.service;

import com.musinsa.urlShort.model.UrlDetailReqVo;
import com.musinsa.urlShort.model.UrlInfoVo;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UrlService {
    List<UrlInfoVo> getUrlList();

    String getOriginUrl(String shortUrl);

    String createShortUrl(UrlDetailReqVo reqVo) throws UnsupportedEncodingException;

}
