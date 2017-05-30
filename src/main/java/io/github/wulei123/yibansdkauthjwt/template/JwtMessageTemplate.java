package io.github.wulei123.yibansdkauthjwt.template;


import io.github.wulei123.yibansdkauthjwt.config.JwtMessageConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * Created by 武雷 on 2017/5/25.
 */
@Component
public class JwtMessageTemplate {

    private  JwtMessageConfig jwtMessageConfig;
    private Integer userid = -1;
    private String username;
    private String usernick;
    private char usersex;
    private Boolean islogin = false;
    private String ybhead;
    private Boolean isadmin = false;
    private Integer expiration = 0;

    @Autowired
    public JwtMessageTemplate(JwtMessageConfig jwtMessageConfig) {
        this.jwtMessageConfig = jwtMessageConfig;
    }

    public JwtMessageTemplate(Integer userid, String username, String usernick, char usersex, Boolean islogin, String ybhead, Boolean isadmin, Integer expiration) {
        this.userid = userid;
        this.username = username;
        this.usernick = usernick;
        this.usersex = usersex;
        this.islogin = islogin;
        this.ybhead = ybhead;
        this.isadmin = isadmin;
        this.expiration = expiration;
    }

    public void setUserInfo(YiBanUserInfoTemplate yiBanUserInfo, Boolean isadmin){
        this.userid = yiBanUserInfo.visit_user.userid;
        this.username = yiBanUserInfo.visit_user.username;
        this.usernick = yiBanUserInfo.visit_user.usernick;
        this.usersex = yiBanUserInfo.visit_user.usersex;
        this.ybhead = yiBanUserInfo.visit_user.userhead;
        this.islogin = true;
        this.expiration = LocalDateTime.now().getSecond() + jwtMessageConfig.getExpiresSecond();
        this.isadmin = isadmin;
//        this.isadmin = commonAdminRepository.findByYibanid(yiBanUserInfo.visit_user.userid) != null;
    }
    public void setUserInfo(YiBanUserInfoTemplate yiBanUserInfo){
        this.userid = yiBanUserInfo.visit_user.userid;
        this.username = yiBanUserInfo.visit_user.username;
        this.usernick = yiBanUserInfo.visit_user.usernick;
        this.usersex = yiBanUserInfo.visit_user.usersex;
        this.ybhead = yiBanUserInfo.visit_user.userhead;
        this.islogin = true;
        this.expiration = LocalDateTime.now().getSecond() + jwtMessageConfig.getExpiresSecond();
        this.isadmin = false;
//        this.isadmin = commonAdminRepository.findByYibanid(yiBanUserInfo.visit_user.userid) != null;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernick() {
        return usernick;
    }

    public void setUsernick(String usernick) {
        this.usernick = usernick;
    }

    public char getUsersex() {
        return usersex;
    }

    public void setUsersex(char usersex) {
        this.usersex = usersex;
    }

    public Boolean getIslogin() {
        return islogin;
    }

    public void setIslogin(Boolean islogin) {
        this.islogin = islogin;
    }

    public String getYbhead() {
        return ybhead;
    }

    public void setYbhead(String ybhead) {
        this.ybhead = ybhead;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }

}