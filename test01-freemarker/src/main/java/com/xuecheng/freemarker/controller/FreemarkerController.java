package com.xuecheng.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-02 19:48
 **/
@RequestMapping("/freemarker")
@Controller
public class FreemarkerController {

    @RequestMapping("/demo")
    public String demo(Model model){
        model.addAttribute("name","黑马程序员");
        System.out.println("name.............");
        //返回模板文件名称
        return "test1";
    }
}
