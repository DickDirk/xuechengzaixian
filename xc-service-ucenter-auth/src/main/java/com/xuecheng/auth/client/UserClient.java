package com.xuecheng.auth.client;

import com.xuecheng.framework.client.XcServiceList;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-23 18:45
 **/
@FeignClient(value = XcServiceList.XC_SERVICE_UCENTER)
@Component
public interface UserClient {
    @GetMapping("/ucenter/getuserext")
    XcUserExt getUserext(@RequestParam("username") String username);

}
