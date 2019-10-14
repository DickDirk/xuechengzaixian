package com.xuecheng.api.ucenter;

import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-23 17:20
 **/
@Api(value = "用户中心",description = "用户中心管理")
public interface UcenterControllerApi {
    @ApiOperation("查询用户")
    XcUserExt getUserext(String username);
}
