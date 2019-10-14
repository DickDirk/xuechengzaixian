package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-07 20:13
 **/
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {
}
