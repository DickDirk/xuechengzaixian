package com.xuecheng.ucenter.service;

import com.xuecheng.framework.domain.ucenter.XcCompanyUser;
import com.xuecheng.framework.domain.ucenter.XcMenu;
import com.xuecheng.framework.domain.ucenter.XcUser;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.ucenter.dao.XcCompanyUserRepository;
import com.xuecheng.ucenter.dao.XcMenuMapper;
import com.xuecheng.ucenter.dao.XcUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-23 17:26
 **/
@Service
public class UserService {
    @Autowired
    XcUserRepository xcUserRepository;
    @Autowired
    XcCompanyUserRepository xcCompanyUserRepository;
    @Autowired
    XcMenuMapper xcMenuMapper;
    /**
     * 根据用户账号查询用户信息
     * @param username
     * @return
     */
    public XcUser findXcUserByUsername(String username){
        XcUser xcUser = xcUserRepository.findXcUserByUsername(username);
        return xcUser;
    }

    /**
     * 根据用户账号查询用户信息,返回用户扩展信息
     * @param username
     * @return
     */
    public XcUserExt getUserExt(String username) {
        XcUser xcUser = this.findXcUserByUsername(username);
        //判断
            if (xcUser == null){
                return null;
            }
        //获取用户id
        String id = xcUser.getId();
        //根据用户id查询用户的权限
        List<XcMenu> permission = xcMenuMapper.selectPermissionByUserId(id);

        //根据id查询用户所属公司信息
        XcCompanyUser xcCompanyUser = xcCompanyUserRepository.findByUserId(id);
        String companyId = null;
        if (xcCompanyUser!=null){
            companyId =  xcCompanyUser.getCompanyId();
        }

        XcUserExt xcUserExt = new XcUserExt();
        BeanUtils.copyProperties(xcUser,xcUserExt);
        xcUserExt.setCompanyId(companyId);
        //设置用户的权限
        xcUserExt.setPermissions(permission);
        return xcUserExt;
    }
}
