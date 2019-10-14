package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-04 22:04
 **/
public class Producer03_routing {
    //队列的名称
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    private static final String EXCHANGE_ROUTING_INFORM = "exchange_routing_inform";
    private static final String ROUTINGKEY_EMAIL="inform_email";
    private static final String ROUTINGKEY_SMS="inform_sms";
    public static void main(String[] args) {
        //创建连接
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
            param1: 队列名称 QUEUE_INFORM_EMAIL(邮箱对列) QUEUE_INFORM_SMS(发短信的队列)
            param2: 是否持久化 如果持久化 mq重启后队列还在
            param3: 队列是否独占此连接
            param4: 队列不再使用是否自动删除次此列
            param5: 队列参数
             */
            channel.queueDeclare(QUEUE_INFORM_EMAIL, true, false, false, null);
            channel.queueDeclare(QUEUE_INFORM_SMS, true, false, false, null);
            //声明一个交换机
            /*参数: String exchange, BuiltinExchangeType type
             1. 交换机的名称
             2. 交换机的类型
             */
            channel.exchangeDeclare(EXCHANGE_ROUTING_INFORM, BuiltinExchangeType.DIRECT);
            /*参数: String queue, String exchange, String routingKey
              1. 队列名称
              2. 交换机名称
              3.路由key
             */
            //交换机和队列的绑定 (绑定两个)
            channel.queueBind(QUEUE_INFORM_EMAIL,EXCHANGE_ROUTING_INFORM,ROUTINGKEY_EMAIL);
            channel.queueBind(QUEUE_INFORM_EMAIL,EXCHANGE_ROUTING_INFORM,"inform");
            channel.queueBind(QUEUE_INFORM_SMS,EXCHANGE_ROUTING_INFORM,ROUTINGKEY_SMS);
            channel.queueBind(QUEUE_INFORM_SMS,EXCHANGE_ROUTING_INFORM,"inform");
            /*
             发邮件消息
             */
            for (int i = 0; i < 5; i++) {
                String message = "email inform to user " + i;
                /* 参数: String exchange, String routingKey, BasicProperties props, byte[] body
                  1. 交换机名称
                  2. 路由key
                  3. 消息属性
                  4. 消息内容

                 */
                channel.basicPublish(EXCHANGE_ROUTING_INFORM, QUEUE_INFORM_EMAIL, null, message.getBytes());
                System.out.println("send  message is" + message);
            }
             /*
             发短信消息
             */
            for (int i = 1; i < 5; i++) {
                String message = " sms inform to user " + i;
                /* 参数: String exchange, String routingKey, BasicProperties props, byte[] body
                  1. 交换机名称
                  2. 路由key
                  3. 消息属性
                  4. 消息内容

                 */
                channel.basicPublish(EXCHANGE_ROUTING_INFORM, QUEUE_INFORM_SMS, null, message.getBytes());
                System.out.println("send  message is" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
