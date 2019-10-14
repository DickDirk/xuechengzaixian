package com.xuecheng.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获类
 *
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-01 16:23
 **/
@ControllerAdvice //控制器增强
public class ExceptionCatch {
    //打印日志
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);
    //定义ImmutableMap 存储的数据稳定 而且线程安全 使用EXCEPTION存放异常代码和错误信息的映射
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;

    //使用builder来构建一个异常类型和错误代码的异常
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    //捕获CustomException异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException e) {
        //获取日志信息
        LOGGER.error("catch exception : {}", e.getMessage());
        //捕获异常
        ResultCode resultCode = e.getResultCode();
        ResponseResult responseResult = new ResponseResult(resultCode);
        return responseResult;
    }


    //捕获Exception异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
        //获取日志信息
        LOGGER.error("catch exception : {}", exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build(); //EXCEPTIONS构建成功
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseResult(resultCode);
        } else {
            //返回99999异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }

    }

    static {
        //加入基础异常类型的信息
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }
}
