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
 * @create: 2019-08-04 20:49
 **/
public class Producer02_publish {
    private static final String QUEUE_INFORM_SMS = "queue_inform_sms";
    private static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
    private static final String EXCHANGE_FANOUT_INFORM = "exchange_fanout_inform";

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
            param1: 队列名称 QUEUE_INFORM_EMAIL(邮箱对列) QUEUE_INFORM_SMS(发短信的队列)
            param2: 是否持久化 如果持久化 mq重启后队列还在
            param3: 队列是否独占此连接
            param4: 队列不再使用是否自动删除次此列
            param5: 队列参数
             */
            channel.queueDeclare(QUEUE_INFORM_EMAIL,true,false,false,null);
            channel.queueDeclare(QUEUE_INFORM_SMS,true,false,false,null);
            //声明一个交换机
            /*参数: String exchange, BuiltinExchangeType type
             1. 交换机的名称
             2. 交换机的类型
                    Direct exchange（直连交换机）
                    Fanout exchange（扇型交换机）
                    Topic exchange（主题交换机）
                    Headers exchange（头交换机）
             */
            channel.exchangeDeclare(EXCHANGE_FANOUT_INFORM, BuiltinExchangeType.FANOUT);
            /*参数: String queue, String exchange, String routingKey
              1. 队列名称
              2. 交换机名称
              3.路由key
             */
            //交换机和队列的绑定 (绑定两个)
            channel.queueBind(QUEUE_INFORM_EMAIL,EXCHANGE_FANOUT_INFORM,"");
            channel.queueBind(QUEUE_INFORM_SMS,EXCHANGE_FANOUT_INFORM,"");

            for (int i = 0; i < 5; i++) {
                String message = "inform to user " + i;
                /* 参数: String exchange, String routingKey, BasicProperties props, byte[] body
                  1. 交换机名称
                  2. 路由key  在FANOUT模式下用空字符串
                  3. 消息属性
                  4. 消息内容

                 */
                channel.basicPublish(EXCHANGE_FANOUT_INFORM,"",null,message.getBytes());
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
