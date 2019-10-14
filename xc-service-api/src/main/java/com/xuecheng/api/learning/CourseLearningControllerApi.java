package com.xuecheng.api.learning;

import com.xuecheng.framework.domain.learning.GetMediaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-20 20:36
 **/
@Api(value = "录播课程学习管理",description = "录播课程学习管理")
public interface CourseLearningControllerApi {
    @ApiOperation("获取课程学习地址")
    GetMediaResult getmedia(String courseId, String teachplanId);
}
