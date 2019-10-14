package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-26 15:42
 **/
@Mapper
public interface XcMenuMapper {
    List<XcMenu> selectPermissionByUserId(String userid);
}
