package com.sy.urlShort.service;

import com.sy.urlShort.model.UrlDetailReqVo;
import com.sy.urlShort.model.UrlInfoVo;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UrlService {
    List<UrlInfoVo> getUrlList();

    String getOriginUrl(String shortUrl);

    String createShortUrl(UrlDetailReqVo reqVo) throws UnsupportedEncodingException;

}
