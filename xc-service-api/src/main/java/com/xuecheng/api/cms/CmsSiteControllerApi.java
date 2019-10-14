package com.xuecheng.api.cms;

import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description 定义接口 (获取页面静态化中轮播图的URL)
 * @author: liumengke
 * @create: 2019-08-02 11:23
 **/
@Api(value = "cms配置模板管理",description = "cms配置模板接口，提供数据模板的查询接口")
public interface CmsSiteControllerApi {
    @ApiOperation("根据id查询CMS模板信息")
    QueryResponseResult findName(String siteId);
}
