package com.xuecheng.search.controller;

import com.xuecheng.api.search.EsCourseControllerApi;
import com.xuecheng.framework.domain.course.CoursePub;
import com.xuecheng.framework.domain.course.TeachplanMediaPub;
import com.xuecheng.framework.domain.search.CourseSearchParam;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.search.service.EsCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-15 08:55
 **/
@RestController
@RequestMapping("/search/course")
public class EsCourseController implements EsCourseControllerApi {
    @Autowired
    EsCourseService esCourseService;

    /**
     * 课程搜索
     * @param page
     * @param size
     * @param courseSearchParam
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult<CoursePub> list(@PathVariable("page") int page,@PathVariable("size") int size, CourseSearchParam courseSearchParam) {
        return esCourseService.list(page,size,courseSearchParam);
    }

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    @Override
    @GetMapping("/getall/{id}")
    public Map<String, CoursePub> getall(@PathVariable("id") String id) {
        return esCourseService.getall(id);
    }

    /**
     * 根据课程计划查询媒资信息
     * @param teachplanId
     * @return
     */
    @Override
    @GetMapping("/getmedia/{teachplanId}")
    @CrossOrigin(origins = "*")
    public TeachplanMediaPub getmedia(@PathVariable("teachplanId") String teachplanId) {
        String [] teachplanIds = new String[]{teachplanId};
        //通过service查询ES获取课程的媒资信息
        QueryResponseResult<TeachplanMediaPub> mediaPubQueryResponseResult = esCourseService.getmedia(teachplanIds);
        QueryResult<TeachplanMediaPub> queryResult = mediaPubQueryResponseResult.getQueryResult();
        if (queryResult!=null&&queryResult.getList()!=null&&queryResult.getList().size()>0){
            //返回课程计划对应的媒资信息
            return queryResult.getList().get(0);
        }
        return new TeachplanMediaPub();
    }
}
