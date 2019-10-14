package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 *异常抛出类
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-01 16:19
 **/
public class ExceptionCast {
    //使用此静态方法抛出自定义异常
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
