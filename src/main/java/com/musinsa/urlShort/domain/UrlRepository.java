package com.musinsa.urlShort.domain;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UrlRepository {
    List<Map<String, Object>> getUrlInfo();
}
