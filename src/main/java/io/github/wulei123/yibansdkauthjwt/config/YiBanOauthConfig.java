package io.github.wulei123.yibansdkauthjwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 武雷 on 2017/5/26.
 */
@Component
@ConfigurationProperties(prefix = "yibanoauth.app")
public class YiBanOauthConfig{
    private String appId;
    private String appKey;

    public YiBanOauthConfig() {
    }

    public YiBanOauthConfig(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}