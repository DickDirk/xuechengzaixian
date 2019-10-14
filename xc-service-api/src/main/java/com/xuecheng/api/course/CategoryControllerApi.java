package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-08 20:48
 **/
@Api(value = "课程分类管理", description = "课程分类管理", tags = {"课程分类管理"})
public interface CategoryControllerApi {
    @ApiOperation("课程查询分类")
    CategoryNode findList();
}
