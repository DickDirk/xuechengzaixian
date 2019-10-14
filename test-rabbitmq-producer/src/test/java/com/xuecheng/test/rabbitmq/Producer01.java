package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-04 18:39
 **/
public class Producer01 {

    private static final String QUEUE = "helloworld";

    public static void main(String[] args) {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672); //端口
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/"); //rabbitmq默认的虚拟机 相当于一个独立的MQ服务

        //创建和rabbitMq连接的TCP
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection();
            //创建域exchange的通道,每个连接可以创建多个通道 ,每个通道就是一个会话任务
            channel = connection.createChannel();
            /*
            声明对列,如果rabbit中没有此队列将自动创建
            param1: 队列名称
            param2: 是否持久化 如果持久化 mq重启后队列还在
            param3: 队列是否独占此连接
            param4: 队列不再使用是否自动删除次此列
            param5: 队列参数
             */
            channel.queueDeclare(QUEUE, true, false, false, null);
            String message = "helloWord JAVA";
            //发送消息
            /*消息发布方法
            param1: exchange的名称 如果没有指定将使用默认的
            param2: routingkey 消息的路由key,是用于exchange(交换机)将消息转发到指定的消息队列
            param3: 消息包含的属性
            param4: 消息体
             默认的交换机,routing就等于队列名称.
             */
            channel.basicPublish("", QUEUE, null, message.getBytes());
            System.out.println("Send Message is :" + message);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            //先关闭通道
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            //再关闭连接
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
