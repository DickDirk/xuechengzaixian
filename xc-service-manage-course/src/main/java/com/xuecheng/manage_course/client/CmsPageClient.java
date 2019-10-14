package com.xuecheng.manage_course.client;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.cms.response.CmsPostPageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-11 18:44
 **/
@FeignClient(value = "XC-SERVICE-MANAGE-CMS")
public interface CmsPageClient {
    /**
     * 根据页面id查询页面信息 , 远程调用cms请求参数
     * @param Id
     * @return
     */
    @GetMapping("/cms/page/get/{id}")
    CmsPage findById(@PathVariable("id") String Id);

    /**
     * 保存页面信息
     * @param cmsPage
     * @return
     */
    @PostMapping("/cms/page/save")
    CmsPageResult save(@RequestBody CmsPage cmsPage);

    /**
     * 一键发布页面
     * @param cmsPage
     * @return
     */
    @PostMapping("/cms/page/postPageQuick")
    CmsPostPageResult postPageQuick(@RequestBody CmsPage cmsPage);
}
