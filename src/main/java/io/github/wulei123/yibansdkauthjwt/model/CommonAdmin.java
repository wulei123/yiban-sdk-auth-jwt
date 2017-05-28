package io.github.wulei123.yibansdkauthjwt.model;

import javax.persistence.*;

/**
 * Created by 武雷 on 2017/5/26.
 */
@Entity
@Table(name = "common_admin")
public class CommonAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int yibanid;

    public CommonAdmin() {
    }

    public CommonAdmin(int yibanid) {
        this.yibanid = yibanid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYibanid() {
        return yibanid;
    }

    public void setYibanid(int yibanid) {
        this.yibanid = yibanid;
    }
}

