package com.xuecheng.manag_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.manage_cms.ManageCmsApplication;
import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-07-31 21:50
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageCmsApplication.class)
public class ServiceTest {
    @Autowired
    private PageService pageService;
    /**
      测试添加
     */
    @Test
    public void testSave() {
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("test002");
        cmsPage.setPageAliase("测试");
        CmsPageResult add = pageService.add(cmsPage);
        System.out.println(add);
    }

    /**
     * 测试静态化生成页面
     */
    @Test
    public void test() {
        String pageHtml = pageService.getPageHtml("5d43fe36c4f1bd46c8e384e8");
        System.out.println(pageHtml);

    }
}












