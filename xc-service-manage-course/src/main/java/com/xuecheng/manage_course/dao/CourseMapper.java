package com.xuecheng.manage_course.dao;

import com.github.pagehelper.Page;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper {
    //根据id查询课程基础
    CourseBase findCourseBaseById(String id);
    //分页查询我的课程
    Page<CourseInfo> findCourseListPage(CourseListRequest courseListRequest);
}
