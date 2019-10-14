package com.xuecheng.manag_cms.dao;

import com.xuecheng.manage_cms.ManageCmsApplication;
import com.xuecheng.manage_cms.dao.CmsTemplateRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-13 11:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageCmsApplication.class)
public class CmsTemplateRepositoryTest {
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;
  /*  @Test
    public void test(){
        CmsTemplate template = cmsTemplateRepository.findByTemplate("5ad9a24d68db5239b8fef199");
        System.out.println(template);

    }*/
}
