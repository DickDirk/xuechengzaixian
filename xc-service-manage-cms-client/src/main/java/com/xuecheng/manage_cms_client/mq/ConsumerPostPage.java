package com.xuecheng.manage_cms_client.mq;

import com.alibaba.fastjson.JSON;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms_client.dao.CmsPageRepository;
import com.xuecheng.manage_cms_client.service.PageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-06 15:42
 **/
@Component
public class ConsumerPostPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerPostPage.class);
    @Autowired
    CmsPageRepository cmsPageRepository;
    @Autowired
    PageService pageService;
    @RabbitListener(queues = {"${xuecheng.mq.queue}"})
    public void postPage(String msg){
        //解析消息
        Map map = JSON.parseObject(msg, Map.class);
        String pageId = (String) map.get("pageId");
        //校验
        CmsPage cmsPage = pageService.findCmsPageById(pageId);
        if (cmsPage == null){
            //打印日志
            LOGGER.error("receive cms post page,cmsPage is null:{}",pageId);
            return;
        }

        //调用service方法将页面从gridFs中下载到服务器
        pageService.savePageToServerPath(pageId);

    }

}
