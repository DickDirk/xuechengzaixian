package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.Teachplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: xc_EduService01
 * @description  查询课程跟节点的接口
 * @author: liumengke
 * @create: 2019-08-07 20:41
 **/
public interface TeachplanRepository extends JpaRepository<Teachplan, String> {
    //根据课程id和父节点id查出节点列表 可以查出根节点
    List<Teachplan> findByCourseidAndParentid(String courseId,String ParentId);
}
