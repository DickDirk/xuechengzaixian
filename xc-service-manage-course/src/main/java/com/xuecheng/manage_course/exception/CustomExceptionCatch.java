package com.xuecheng.manage_course.exception;

import com.xuecheng.framework.exception.ExceptionCatch;
import com.xuecheng.framework.model.response.CommonCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-26 10:29
 **/
@ControllerAdvice //控制器增强
public class CustomExceptionCatch extends ExceptionCatch{
        static {
            builder.put(AccessDeniedException.class, CommonCode.UNAUTHORISE);
        }
}
