package com.xuecheng.api.auth;

import com.xuecheng.framework.domain.ucenter.request.LoginRequest;
import com.xuecheng.framework.domain.ucenter.response.JwtResult;
import com.xuecheng.framework.domain.ucenter.response.LoginResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-22 18:36
 **/
@Api(value = "用户认证",description = "用户认证接口")
public interface AuthControllerApi {
    @ApiOperation("用户登录")
    LoginResult login(LoginRequest loginRequest);
    @ApiOperation("退出")
    ResponseResult logout();
    @ApiOperation("查询userjwt令牌")
    JwtResult userjwt();
}
