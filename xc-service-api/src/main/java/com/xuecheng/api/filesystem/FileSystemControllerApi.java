package com.xuecheng.api.filesystem;

import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-10 12:30
 **/

@Api(value = "文件接口管理",description = "文件管理接口，提供页面的管理、查询接口")
public interface FileSystemControllerApi {
    @ApiOperation("上传文件接口")
    UploadFileResult upload(MultipartFile multipartFile,
                            String filetag,
                            String businesskey,
                            String metadata);
}
