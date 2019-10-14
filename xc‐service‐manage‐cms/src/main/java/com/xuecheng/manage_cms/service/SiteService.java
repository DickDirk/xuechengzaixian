package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.CmsSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-07 20:10
 **/
@Service
public class SiteService {
    @Autowired
    CmsSiteRepository cmsSiteRepository;

    public QueryResponseResult findSite() {
        List<CmsSite> all = cmsSiteRepository.findAll();
        ResponseResult respunseResult = new ResponseResult();

       // QueryResponseResult queryResponseResult = new QueryResponseResult(respunseResult.);
        return null;
    }
}
