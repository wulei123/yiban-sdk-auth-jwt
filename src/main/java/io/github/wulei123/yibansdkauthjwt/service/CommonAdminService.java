package io.github.wulei123.yibansdkauthjwt.service;

import io.github.wulei123.yibansdkauthjwt.repository.CommonAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 武雷 on 2017/5/26.
 */
public class CommonAdminService{
    @Autowired
    private CommonAdminRepository commonAdminRepository;
    public Boolean checkAdmin(int yiBanId){
        return this.commonAdminRepository.findByYibanid(yiBanId) != null;
    }
}
