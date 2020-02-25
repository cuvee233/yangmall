package com.weiyi.ymall.manager.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MyUploadUtil {
    /**
     * 文件上传方法
     *
     * @param multipartFile
     * @return
     */
    public static final String fileUpLoad(MultipartFile multipartFile) {

        // 图片的url地址
        String imgUrl = "http://192.168.126.100";

        // 获取配置文件的路径 注意：要加斜杠，从根目录开始
        String tracker = MyUploadUtil.class.getResource("/tracker.conf").getPath();

        try {
            // 初始化fastdfs客户端
            ClientGlobal.init(tracker);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        // 新建一个tracker客户端对象
        TrackerClient trackerClient = new TrackerClient();

        try {
            // 获得一个trackerserver的实例
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            // 通过tracker获取storage链接
            StorageClient storageClient = new StorageClient(trackerServer, null);
            //  获取上传文件的二进制地址
            byte[] bytes = multipartFile.getBytes();
            // 获取文件的原始名
            String originalFilename = multipartFile.getOriginalFilename();
            // 获取文件的后缀名
            int index = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(index + 1);
            // 上传文件
            String[] pngs = storageClient.upload_file(bytes, extName, null);

            for (String png : pngs) {
                imgUrl += "/" + png;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgUrl;
    }
}
