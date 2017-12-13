package com.fs.ntes.utils.oss;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.OSSClient;
import com.fs.ntes.dto.UploadDto;
import com.fs.ntes.utils.FileUtils;
import com.fs.ntes.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class OSSUtils {

    @Autowired
    private AliyunConfig aliyunConfig;

    private static OSSClient ossClient = new OSSUtils().init();

    public static String upload(InputStream inputStream) throws IOException {
        String path = "exam/cover/" + UUID.randomUUID() + "." + FileType.getFileTypeByStream(inputStream);

        // 上传文件流
        System.out.println(JSON.toJSONString(ossClient.putObject("fmsbb", path, inputStream)));

        // 关闭client
        //ossClient.shutdown();
        LogUtils.info("key:" + path);

        return path;

    }

    public static UploadDto upload(File file) throws IOException {
        String path = "exam/cover/" + UUID.randomUUID() + "." + FileType.getFileTypeByStream(FileUtils.File2byte(file));
        // 上传文件流
        ossClient.putObject("fmsbb", path, file);

        LogUtils.info("key:" + path);

        return new UploadDto(0, "", path);

    }


    protected OSSClient init() {
        //return new OSSClient(aliyunConfig.getEndpoint(), aliyunConfig.getAccessKeyId(), aliyunConfig.getAccessKeySecret());
        return new OSSClient("oss-cn-shanghai.aliyuncs.com", "LTAIyaw3s6ajUgNN", "tQrppHDVGfkBYG8ccCFXKrmoInCz9k");
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public static final String getContentType(String fileName) {
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if ("bmp".equalsIgnoreCase(fileExtension)) return "image/bmp";
        if ("gif".equalsIgnoreCase(fileExtension)) return "image/gif";
        if ("jpeg".equalsIgnoreCase(fileExtension) || "jpg".equalsIgnoreCase(fileExtension) || "png".equalsIgnoreCase(fileExtension))
            return "image/jpeg";
        if ("html".equalsIgnoreCase(fileExtension)) return "text/html";
        if ("txt".equalsIgnoreCase(fileExtension)) return "text/plain";
        if ("vsd".equalsIgnoreCase(fileExtension)) return "application/vnd.visio";
        if ("ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension))
            return "application/vnd.ms-powerpoint";
        if ("doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension))
            return "application/msword";
        if ("xml".equalsIgnoreCase(fileExtension)) return "text/xml";
        return "text/html";
    }


}


