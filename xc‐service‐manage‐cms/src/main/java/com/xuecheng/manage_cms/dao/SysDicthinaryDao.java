package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: xc_EduService01
 * @description SysDictionary
 * @author: liumengke
 * @create: 2019-08-09 09:18
 **/
public interface SysDicthinaryDao extends MongoRepository<SysDictionary,String> {
    //查询数据字典类型
    SysDictionary findBydType(String type);
}
