package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-04 19:10
 **/
public class Consumer01 {
    private static final String QUEUE = "helloworld";

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //创建通道
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672); //端口
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/"); //rabbitmq默认的虚拟机 相当于一个独立的MQ服务
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
         /*
            声明对列,如果rabbit中没有此队列将自动创建
            param1: 队列名称
            param2: 是否持久化 如果持久化 mq重启后队列还在
            param3: 队列是否独占此连接
            param4: 队列不再使用是否自动删除次此列
            param5: 队列参数
             */
        channel.queueDeclare(QUEUE, true, false, false, null);
        //实现消费方法
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            /**
             *
             * @param consumerTag 消费标签 用来识别消费者
             * @param envelope  信封
             * @param properties  消息属性
             * @param body  消息内容
             * @throws IOException
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //交换机
                String exchange = envelope.getExchange();
                //消息id mq在change中用来标识消息的id,可用于确认消息已接收
                long deliveryTag = envelope.getDeliveryTag();
                //路由key
                String routingKey = envelope.getRoutingKey();
                //消息内容
                String msg = new String(body,"utf-8");
                System.out.println("msg is: " + msg);
            }

        };
        /* 参数:
        String queue(队列名称),
        boolean autoAck(自动回复消息 如果设置true则自动回复 false 由编程实现回复),
        Consumer callback(消费方法,).

         */
        //监听队列
        channel.basicConsume(QUEUE,true,defaultConsumer);

    }
}
