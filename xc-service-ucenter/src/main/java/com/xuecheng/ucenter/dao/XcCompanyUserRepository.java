package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcCompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-23 17:23
 **/
public interface XcCompanyUserRepository extends JpaRepository<XcCompanyUser,String> {
    //根据用户id查询所属企业
    XcCompanyUser findByUserId(String userId);
}
