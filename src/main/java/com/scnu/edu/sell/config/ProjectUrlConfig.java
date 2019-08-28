package com.scnu.edu.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hepengyu in 0827
 * 2017-07-30 11:43
 */
@Data
@ConfigurationProperties(prefix = "projecturl")
@Component
public class ProjectUrlConfig {

    // 微信公众平台授权url
    public String wechatMpAuthorize;

    // 微信开放平台授权url
    public String wechatOpenAuthorize;

    // 点餐系统
    public String sell;
}
