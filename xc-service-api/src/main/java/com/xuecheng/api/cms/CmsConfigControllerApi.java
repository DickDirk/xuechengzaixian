package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description 定义接口 (获取页面静态化中轮播图的URL)
 * @author: liumengke
 * @create: 2019-08-02 11:23
 **/
@Api(value = "cms配置接口管理",description = "cms配置管理接口，提供数据模型的管理、查询接口")
public interface CmsConfigControllerApi {
    @ApiOperation("根据id查询CMS配置信息")
    CmsConfig getModel(String id);
}
