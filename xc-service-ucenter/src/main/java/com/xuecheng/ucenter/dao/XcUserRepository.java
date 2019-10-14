package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-23 17:23
 **/
public interface XcUserRepository extends JpaRepository<XcUser,String> {
    XcUser findXcUserByUsername(String username);
}
