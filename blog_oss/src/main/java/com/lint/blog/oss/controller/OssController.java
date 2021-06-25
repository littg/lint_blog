package com.lint.blog.oss.controller;

import com.lint.commonutils.R;
import com.lint.oss.service.OssService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description :
 * @Author : Lint
 * @Date: 2021/6/19 20:53
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Resource
    private OssService ossService;

    /**
    * 方法介绍:
    *   上传头像的方法
    * @author: Lint
    * @date: 2021/6/19 20:56
    * @return: com.lint.commonutils.R
    **/
    @PostMapping
    public R uploadOssFile(MultipartFile file){
        //获取上传的头像 MultipartFile
        //方法返回上传到oss的路径
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }

}

