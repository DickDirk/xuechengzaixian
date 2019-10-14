package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-07-25 17:24
 **/

public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String> {

}
