package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.cms.response.CmsPostPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-07-24 21:06
 **/
public interface CmsPageControllerApi {
    //返回查询所有相应的结果
    @ApiOperation("查询所有")
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
    //添＋页面
    @ApiOperation("新增页面")
     CmsPageResult add(CmsPage cmsPage);
    //根据id查询一个
    @ApiOperation("查询一个")
    CmsPage findById(String id);
    //修改页面
    @ApiOperation("修改页面")
    CmsPageResult edit(String id,CmsPage cmsPage);
    //删除
    @ApiOperation("删除页面")
    ResponseResult delete(String id);
    //页面发布的接口
    @ApiOperation("页面发布")
    ResponseResult post(String pageId);
    //保存页面
    @ApiOperation("保存页面")
    CmsPageResult save(CmsPage cmsPage);
    @ApiOperation("一键页面发布")
    CmsPostPageResult postPageQuick(CmsPage cmsPage);
}
