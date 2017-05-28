package io.github.wulei123.yibansdkauthjwt.repository;

import io.github.wulei123.yibansdkauthjwt.model.CommonAdmin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 武雷 on 2017/5/26.
 */
public interface CommonAdminRepository extends CrudRepository<CommonAdmin, Integer> {
    Iterable<CommonAdmin> findByYibanid(int Yibanid);
}