package io.github.wulei123.yibansdkauthjwt.template;

/**
 * Created by 武雷 on 2017/5/26.
 */
public class YiBanUserInfoTemplate{
    public int visit_time;
    public VisitUser visit_user;
    public VisitOauth visit_oauth;

    public class VisitUser{
        public int userid;
        public String username;
        public String usernick;
        public char usersex;
        public String userhead;
    }

    public class VisitOauth{
        public String access_token;
        public int token_expires;
    }
}
