package com.fs.ntes.controller;

import com.alibaba.fastjson.JSON;
import com.fs.ntes.dto.UploadDto;
import com.fs.ntes.utils.FileUtils;
import com.fs.ntes.utils.GeneralUtils;
import com.fs.ntes.utils.LogUtils;
import com.fs.ntes.utils.oss.AliyunConfig;
import com.fs.ntes.utils.oss.OSSUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("upload")
public class UploadController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UploadController.class);



    @RequestMapping("/")
    public @ResponseBody UploadDto upload(HttpServletRequest request, MultipartFile file) {

        UploadDto dto = new UploadDto();
        String fileName = file.getOriginalFilename();

        LogUtils.debug("filename:" + fileName);


        try {
            System.out.println(file.isEmpty());
            return OSSUtils.upload(FileUtils.byte2File(file.getBytes(), GeneralUtils.absPath(), "1111"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        UploadDto.Data data = dto.new Data();
        data.setSrc(fileName);
        dto.setData(data);

        return dto;
    }


}
