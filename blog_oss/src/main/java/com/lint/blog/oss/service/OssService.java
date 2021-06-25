package com.lint.blog.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description :
 * @Author : Lint
 * @Date: 2021/6/19 20:53
 */
public interface OssService {
    /**
    * 方法介绍:
    *   上传文件到oss并返回文件路径
    * @author: Lint
    * @date: 2021/6/19 21:01
    * @return: java.lang.String
    **/
    String uploadFileAvatar(MultipartFile file);
}
