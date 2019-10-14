package com.xuecheng.manag_cms;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.xuecheng.manage_cms.ManageCmsApplication;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-02 12:42
 **/
@SpringBootTest(classes = ManageCmsApplication.class)
@RunWith(SpringRunner.class)
public class GridFsTest {
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;
    /**
     * gridFs course.ftl文件
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testStore2() throws FileNotFoundException {
        //要储存的文件
        File file = new File("e:/course.ftl");
        //定义输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        //向GridFs中存储文件
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "course.ftl");
        //得到文件id
        String s = objectId.toString();
        System.out.println(s);
    }
    /**
     * gridFs 存index_banner.ftl文件
     *
     * @throws FileNotFoundException
     */
    @Test
    public void testStore() throws FileNotFoundException {
        //要储存的文件
        File file = new File("e:/index_banner.ftl");
        //定义输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        //向GridFs中存储文件
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "index_banner.ftl");
        //得到文件id
        String s = objectId.toString();
        System.out.println(s);
    }

    /**
     * gridFs 取文件
     *
     * @throws IOException
     */

    @Test
    public void queryFile() throws IOException {
        //根据id查询文件
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is("5d465086c4f1bd2eac8352af")));
        //打开一个下载流对象
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridFsResource，用于获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        System.out.println(gridFsResource);
        //获取流中的数据
        String content = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");

        System.out.println(content);
    }

}













