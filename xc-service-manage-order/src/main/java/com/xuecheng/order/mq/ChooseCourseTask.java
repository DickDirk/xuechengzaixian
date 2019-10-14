package com.xuecheng.order.mq;

import com.xuecheng.framework.domain.task.XcTask;
import com.xuecheng.order.config.RabbitMQConfig;
import com.xuecheng.order.service.TaskService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-27 19:52
 **/
@Component
public class ChooseCourseTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChooseCourseTask.class);
    @Autowired
    TaskService taskService;

    /**
     * 接受选课相应的结果
     * @param xcTask
     */
    @RabbitListener(queues = RabbitMQConfig.XC_LEARNING_FINISHADDCHOOSECOURSE)
    public void receiveFinishChoosecourseTask(XcTask xcTask){
        if(xcTask!=null && StringUtils.isNotEmpty(xcTask.getId())){
           // 删除任务添加历史任务
            taskService.finishTask(xcTask.getId());
        }
    }
    /**
     *定时获取任务信息 并向mq中发送消息
     */
    @Scheduled(cron="0/3 * * * * *")
    public void sendChoosecourseTask(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(GregorianCalendar.MINUTE,calendar.get(GregorianCalendar.MINUTE)-1);
        Date time = calendar.getTime();
        List<XcTask> list = taskService.findXcTaskList(time, 100);
        System.out.println(list);
        //调用service发布消息 并将添加的任务信息(选课的任务)向mq发送消息
        for (XcTask xcTask : list) {
            //取任务
            if(taskService.getTask(xcTask.getId(),xcTask.getVersion())>0){
                String ex = xcTask.getMqExchange();//要发送的交换机
                String routingKey = xcTask.getMqRoutingkey();//发送消息要带routingKey
                taskService.publish(xcTask,ex,routingKey);
            }
        }
    }





    //定义任务调试策略
//    @Scheduled(cron="0/3 * * * * *")//每隔3秒去执行
//       @Scheduled(fixedRate = 3000) //在任务开始后3秒执行下一次调度
//       @Scheduled(fixedDelay = 3000) //在任务结束后3秒后才开始执行
    public void task1(){
        LOGGER.info("===============测试定时任务1开始===============");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("===============测试定时任务1结束===============");

    }

    /**
     * 串行任务
     */
//    @Scheduled(fixedRate = 3000) //上次执行开始时间后5秒执行
    public void task2(){
        LOGGER.info("===============测试定时任务2开始===============");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("===============测试定时任务2结束===============");
    }
}
