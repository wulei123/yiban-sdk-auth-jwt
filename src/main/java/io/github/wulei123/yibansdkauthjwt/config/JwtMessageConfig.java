package io.github.wulei123.yibansdkauthjwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 武雷 on 2017/5/26.
 */
@Component
@ConfigurationProperties(prefix = "yibanoauth.jwt")
public class JwtMessageConfig {
    private String secret = "secret";
    private int expiresSecond = 14800;

    public JwtMessageConfig() {
    }

    public JwtMessageConfig(String secret, int expiresSecond) {
        this.secret = secret;
        this.expiresSecond = expiresSecond;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(int expiresSecond) {
        this.expiresSecond = expiresSecond;
    }
}