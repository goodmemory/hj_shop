package com.hj.file.controller;

import com.hj.entity.GraceJSONResult;
import com.hj.file.config.MinIOConfig;
import com.hj.file.util.MinIOUtils;
import com.hj.util.DateUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/file")
@Api(tags = "FileController 文件管理接口模块")
@Slf4j
public class FileController {

    @Autowired
    private MinIOConfig minIOConfig;

    /**
     * 文件上传
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/upload")
    public GraceJSONResult upload(MultipartFile file) throws Exception {
        String[] fileParams = file.getOriginalFilename().split(".");
        String newFilename = DateUtil.getCurrentDate() + "." + fileParams[1];
        MinIOUtils.uploadFile(minIOConfig.getBucketName(), newFilename, file.getInputStream());
        String imgUrl = minIOConfig.getFileHost() + "/" + minIOConfig.getBucketName() + "/" + newFilename;
        return GraceJSONResult.ok(imgUrl);
    }
}
