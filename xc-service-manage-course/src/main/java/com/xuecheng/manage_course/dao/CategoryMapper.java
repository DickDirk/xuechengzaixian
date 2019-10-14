package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: xc_EduService01
 * @description 查询分类
 * @author: liumengke
 * @create: 2019-08-08 20:51
 **/
@Mapper
public interface CategoryMapper {
    //查询分类
    CategoryNode selectList();
}
