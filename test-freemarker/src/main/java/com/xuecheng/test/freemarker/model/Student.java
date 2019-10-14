package com.xuecheng.test.freemarker.model;


import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @program: xcEduService01
 * @description
 * @author: lianghaoyang
 * @create: 2019-08-03 15:49
 **/
@Data
@ToString
public class Student {
    private String name; //姓名
    private int age;//年龄
    private Date birthday;//生日
    private float money;//钱包
    private List<Student> friends;//朋友列表
    private Student bestFriend;//最好的朋友
}
