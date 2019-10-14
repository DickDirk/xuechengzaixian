package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-07 15:16
 **/
@Mapper
public interface TeachplanMapper {
    TeachplanNode selectList(String courseId);
}
