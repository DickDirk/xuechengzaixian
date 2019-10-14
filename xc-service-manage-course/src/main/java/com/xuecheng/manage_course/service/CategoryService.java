package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.manage_course.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-08 21:27
 **/
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public CategoryNode findList() {

        return categoryMapper.selectList();
    }


}
