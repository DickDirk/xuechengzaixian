package com.xuecheng.test;

import com.xuecheng.test.fastdfs.TestFastdfsApplication;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-09 21:05
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestFastdfsApplication.class)
public class FastDFsTest {
    /**
     * 文件上传测试
     */
    @Test
    public void testUpload(){
        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient,用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建StorageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            //向storage服务器上传文件
            //本地文件的路径
            String path = "e:/page-success.png";
            //上传成功后拿到文件的id
            String fileId = storageClient1.upload_file1(path, "png", null);
            System.out.println(fileId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件下载测试
     */
    @Test
    public void testDownload(){
        try {
            //加载fastdfs-client.properties配置文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            //定义TrackerClient,用于请求TrackerServer
            TrackerClient trackerClient = new TrackerClient();
            //连接tracker
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取stroage
            StorageServer storeStorage = trackerClient.getStoreStorage(trackerServer);
            //创建StorageClient
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storeStorage);
            //文件id
            String id = "group1/M00/00/01/wKgZmV1OhT-ACGKRAAAZHteHGzw583.png";
            //下载文件
            byte[] bytes = storageClient1.download_file1(id);
            //使用输出流保存文件
            FileOutputStream fileOutputStream = new FileOutputStream(new File("f:/page-success.png"));
            fileOutputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}














