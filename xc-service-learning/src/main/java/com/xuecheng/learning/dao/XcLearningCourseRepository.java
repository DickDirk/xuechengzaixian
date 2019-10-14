package com.xuecheng.learning.dao;

import com.xuecheng.framework.domain.learning.XcLearningCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-28 16:30
 **/
public interface XcLearningCourseRepository extends JpaRepository<XcLearningCourse,String> {
    //根据用户和课程查询选课记录，用于判断是否添加选课
    XcLearningCourse findXcLearningCourseByUserIdAndCourseId(String userId, String courseId);
}
