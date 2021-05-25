package com.sy.urlShort.domain;

import com.sy.urlShort.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UrlRepository {
    List<UrlInfoVo> selectUrlList();

    String selectOriginUrl(String shortUrl);

    UrlInfoVo selectUrlExist(UrlDetailReqVo reqVo);

    void insertUrl(UrlInsertVo reqVo);

    void updateShortUrl(UrlUpdateVo reqVo);

    void updateUrl(UrlUpdateVo reqVo);

    void deleteUrl(UrlDeleteVo reqVo);

}