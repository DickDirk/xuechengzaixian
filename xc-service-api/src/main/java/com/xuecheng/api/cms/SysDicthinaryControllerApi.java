package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.system.SysDictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-09 09:13
 **/
@Api(value = "数字字典接口",description = "提供数据字典接口的查询功能")
public interface SysDicthinaryControllerApi {
    @ApiOperation(value = "数字字典查询接口")
    SysDictionary getType(String type);
}
