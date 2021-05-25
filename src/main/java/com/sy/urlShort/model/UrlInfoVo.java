package com.sy.urlShort.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrlInfoVo {
    private int rid;
    private String originUrl;
    private String shortUrl;
    private int urlCallNum;
}
