package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.dao.SysDicthinaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-09 09:24
 **/
@Service
public class SysDicthinaryService {
    @Autowired
    SysDicthinaryDao sysDicthinaryDao;

    public SysDictionary findDictionaryByType(String type) {
        return sysDicthinaryDao.findBydType(type);
    }
}
