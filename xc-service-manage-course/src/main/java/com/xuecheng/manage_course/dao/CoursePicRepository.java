package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-10 20:15
 **/
public interface CoursePicRepository extends JpaRepository<CoursePic,String> {
    long deleteByCourseid(String courseid);
}
