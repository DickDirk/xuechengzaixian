package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.TeachplanMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-19 20:56
 **/
public interface TeachplanMediaRepository extends JpaRepository<TeachplanMedia,String> {
    //从TeachplanMedia查询课程计划媒资信息
    List<TeachplanMedia> findByCourseId(String courseId);
}
