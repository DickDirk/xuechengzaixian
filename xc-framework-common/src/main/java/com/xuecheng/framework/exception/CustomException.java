package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**
 * 自定义异常捕获类
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-01 16:03
 **/
public class CustomException extends RuntimeException {

    private ResultCode resultCode;
    public CustomException(ResultCode resultCode) {
        //异常信息为错误代码+异常信息
        super("错误代码："+resultCode.code()+"错误信息："+resultCode.message());
        this.resultCode = resultCode;
    }

    /**
     * 取出错误代码的方法
     * @return
     */
    public ResultCode getResultCode(){
        return this.resultCode;
    }
}
