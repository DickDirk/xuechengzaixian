package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.dao.CoursePicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-10 20:17
 **/
@Service
public class CoursePicService {
    @Autowired
    CoursePicRepository coursePicRepository;

    /**
     * 保存课程图片
     * @param courseId
     * @param pic
     * @return
     */
    @Transactional
    public ResponseResult addCoursePic(String courseId,String pic) {
        CoursePic coursePic= null;
        //根据id获取课程图片
        Optional<CoursePic> optional = coursePicRepository.findById(courseId);
        if (optional.isPresent()){
            coursePic = optional.get();
        }
        //如果没有课程图片则新建对象
        if (coursePic == null){
            coursePic = new CoursePic();
        }
        coursePic.setCourseid(courseId);
        coursePic.setPic(pic);
        //保存
        coursePicRepository.save(coursePic);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 查询课程图片
     * @return
     */
    public CoursePic findCoursePic(String courseId){
        Optional<CoursePic> optional = coursePicRepository.findById(courseId);
        if (optional.isPresent()){
            CoursePic coursePic = optional.get();
            return coursePic;
        }
        return null;
    }

    /**
     * 删除课程图片
     * @param courseId
     * @return
     */
    @Transactional
    public ResponseResult delCoursePic(String courseId){
        long ss = coursePicRepository.deleteByCourseid(courseId);
        if (ss>0){
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
    }
}
