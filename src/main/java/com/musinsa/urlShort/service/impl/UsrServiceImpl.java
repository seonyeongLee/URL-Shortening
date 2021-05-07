package com.musinsa.urlShort.service.impl;

import com.musinsa.urlShort.domain.UrlRepository;
import com.musinsa.urlShort.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UsrServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;

    @Override
    public List<Map<String, Object>> getUrlInfo() {
        return urlRepository.getUrlInfo();
    }
}
