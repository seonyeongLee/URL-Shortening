package com.sy.urlShort.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlUpdateVo {
    private int rid;
    private String originUrl;
    private String shortUrl;
    private int urlCallNum;

}