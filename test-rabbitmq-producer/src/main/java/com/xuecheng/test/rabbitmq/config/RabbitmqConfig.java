package com.xuecheng.test.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-05 11:37
 **/
@Configuration
public class RabbitmqConfig {
    //队列的名称
    public static final String QUEUE_INFORM_EMAIL = "queue_inform_email"; //设置email对列
    public static final String QUEUE_INFORM_SMS = "queue_inform_sms";  //设置sms对列
    public static final String EXCHANGE_TOPICS_INFORM = "exchange_topics_inform";
    public static final String ROUTINGKEY_EMAIL="inform.#.email.#"; //设置路由 email
    public static final String ROUTINGKEY_SMS="inform.#.sms.#";   //设置路由 sms


    /**
     * 1.声明交换机(topoic通配符类型的)
     *durable(true) 持久化交换机  mq重启之后交换机还在
     * @return
     */
    @Bean(EXCHANGE_TOPICS_INFORM)
    public Exchange EXCHANGE_TOPICS_INFORM(){
        return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(false).build();
    }

    /**
     * 2.声明队列QUEUE_INFORM_EMAIL
     */
    @Bean(QUEUE_INFORM_EMAIL)
    public Queue QUEUE_INFORM_EMAIL(){
        return new Queue(QUEUE_INFORM_EMAIL);
    }
    /**
     * 3.声明队列QUEUE_INFORM_SMS
     */
    @Bean(QUEUE_INFORM_SMS)
    public Queue QUEUE_INFORM_SMS(){
        return new Queue(QUEUE_INFORM_SMS);
    }

    /**
     * 4.绑定交换机和队列-->手机
     * @param queue
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(QUEUE_INFORM_SMS) Queue queue,
                                            @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();

    }
    /**
     * 5.绑定交换机和队列-->邮箱
     * @param queue
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue,
                                            @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMAIL).noargs();

    }
}
