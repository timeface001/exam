package com.fs.ntes.utils.oss;

import com.aliyun.oss.OSSClient;
import com.fs.ntes.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.UUID;

public class OSSUtils {

    @Autowired
    private AliyunConfig aliyunConfig;

    private static OSSClient ossClient = new OSSUtils().init();

    public static String upload(File file) throws FileNotFoundException {
        String path = "/exam/cover/" + UUID.randomUUID() + "," + FileType.getFileByFile(file);
        // 上传文件流
        InputStream inputStream = new FileInputStream(file);
        ossClient.putObject("fmsbb", path, inputStream);
        // 关闭client
        //ossClient.shutdown();
        LogUtils.info("key:" + path);

        return path;

    }

    public static String upload(InputStream inputStream) throws IOException {
        String path = "exam/cover/" + UUID.randomUUID() + "." + FileType.getFileTypeByStream(inputStream);
        LogUtils.info("key:" + inputStream.available());

        int count=inputStream.available();
        while (count == 0) {
            count = inputStream.available();
            LogUtils.info("go on...");
        }
        // 上传文件流
        ossClient.putObject("fmsbb", path, inputStream);
        // 关闭client
        //ossClient.shutdown();
        LogUtils.info("key:" + path);

        return path;

    }


    protected OSSClient init() {
        //return new OSSClient(aliyunConfig.getEndpoint(), aliyunConfig.getAccessKeyId(), aliyunConfig.getAccessKeySecret());
        return new OSSClient("oss-cn-shanghai.aliyuncs.com", "LTAIyaw3s6ajUgNN", "tQrppHDVGfkBYG8ccCFXKrmoInCz9k");
    }


}


