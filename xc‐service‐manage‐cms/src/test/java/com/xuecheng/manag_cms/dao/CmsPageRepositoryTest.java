package com.xuecheng.manag_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.ManageCmsApplication;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-07-25 17:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageCmsApplication.class)
public class CmsPageRepositoryTest {
    @Autowired
    private CmsPageRepository cmsPageRepository;

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<CmsPage> list = cmsPageRepository.findAll();
        System.out.println(list);
    }

    /**
     * 分页查询
     */
    @Test
    public void testFindByPage() {
        //分页参数
        int page = 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);

    }

    /**
     * 自定义条件查询
     */
    @Test
    public void testFindAllByExample() {
        //分页参数
        int page = 0;
        int size = 10;
        Pageable pageable = PageRequest.of(page, size);
        //条件值对象
        CmsPage cmsPage = new CmsPage();
        //要查询站点的页面 5a751fab6abb5044e0d19ea1
       // cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        //根据模板id查询
        // cmsPage.setTemplateId("5a962bf8b00ffc514038fafa");
        //根据页面别名查询
        cmsPage.setPageAliase("轮播");
        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher
                .GenericPropertyMatchers.contains()); //contains 包含关键字
        System.out.println("1.........." + exampleMatcher);
        // 定义Example
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        System.out.println("2.........." + example);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println("3..........." + all);
        List<CmsPage> content = all.getContent();
        System.out.println("4............" + content);
    }

    /**
     * 修改
     */
    //修改
    @Test
    public void testUpdate() {
        //查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5b4b1d8bf73c6623b03f8cec");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            //设置要修改值
            cmsPage.setPageAliase("test01");
            //修改
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }

    }

    //根据页面名称查询
    @Test
    public void testFindByPageName() {
        CmsPage cmsPage = cmsPageRepository.findByPageName("10101.html");
        System.out.println(cmsPage);
    }

    //根据别名查询
    @Test
    public void testFindByPageAliase() {
        CmsPage cmsPage = cmsPageRepository.findByPageAliase("首页");
        System.out.println(cmsPage);
    }
}
