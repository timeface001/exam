package com.fs.ntes.controller;

import com.fs.ntes.dto.UploadDto;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("upload")
public class UploadController extends BaseController {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UploadController.class);

    @RequestMapping("/")
    public @ResponseBody UploadDto upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

        UploadDto dto = new UploadDto();
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();

        logger.debug("filename:" + fileName);

        UploadDto.Data data = dto.new Data();
        data.setSrc(fileName);
        dto.setData(data);

        return dto;
    }
}
