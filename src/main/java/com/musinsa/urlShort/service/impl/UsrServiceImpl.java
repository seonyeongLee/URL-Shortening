package com.musinsa.urlShort.service.impl;

import com.musinsa.common.utility.EncodeUtility;
import com.musinsa.common.utility.ObjectUtility;
import com.musinsa.urlShort.domain.UrlRepository;
import com.musinsa.urlShort.model.*;
import com.musinsa.urlShort.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsrServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Override
    public List<UrlInfoVo> getUrlList() {
        return this.urlRepository.selectUrlList();
    }

    @Override
    public String getOriginUrl(String shortUrl) {
        return this.urlRepository.selectOriginUrl(shortUrl);
    }

    @Override
    public String createShortUrl(UrlDetailReqVo reqVo) throws UnsupportedEncodingException {
        String shortUrl;

        reqVo.setOriginUrl(URLDecoder.decode(reqVo.getOriginUrl(),"UTF-8"));

        //해당 url과 동일한 url 이 존재하는가
        UrlInfoVo existUrlInfo = this.urlRepository.selectUrlExist(reqVo);

        if( ObjectUtility.isEmpty(existUrlInfo) ) { // 존재X -> 단축 URl 생성, 저장
           this.urlRepository.insertUrl(UrlInsertVo.builder()
                                        .originUrl(reqVo.getOriginUrl()).build());

           UrlInfoVo seqVo = this.urlRepository.selectUrlExist(reqVo);
           try {
               int ridSeq = seqVo.getRid();
               shortUrl = this.encodingUrl(ridSeq);

               UrlUpdateVo updateVo = UrlUpdateVo.builder()
                       .rid(ridSeq).shortUrl(shortUrl)
                       .build();
               this.urlRepository.updateShortUrl(updateVo);
           } catch (NoSuchAlgorithmException exception) {
               this.urlRepository.deleteUrl(UrlDeleteVo.builder().rid(seqVo.getRid()).build());
               return "";
           }

        } else { // 존재 -> numCnt ++
            shortUrl = existUrlInfo.getShortUrl();

            UrlUpdateVo updateVo = UrlUpdateVo.builder()
                    .rid(existUrlInfo.getRid()).urlCallNum(existUrlInfo.getUrlCallNum() + 1)
                    .build();
            this.urlRepository.updateUrl(updateVo);
        }

        return shortUrl;
    }

    private String encodingUrl(int seq) throws NoSuchAlgorithmException {
        return EncodeUtility.urlEncoder(seq);
    }
}
