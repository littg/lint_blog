package com.lint.blog.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.lint.oss.service.OssService;
import com.lint.oss.util.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @Description :
 * @Author : Lint
 * @Date: 2021/6/19 20:54
 */
@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {
        //通过工具类获取配置文件值
        String endpoint = ConstantPropertiesUtils.END_POIND;
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        OSS ossClient = null;
        try {

            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            //获取上传文件的输入流
            InputStream inputStream = file.getInputStream();

            // 调用方法实现上传
            //第一个参数 Bucket名称 ， 第二个参数 上传到oss文件路径和文件名称 , 第三个参数 上传流
            //获取文件名称 在文件名称中加一个随机的唯一的值，避免覆盖
            String filename = UUID.randomUUID().toString().replaceAll("-","")+file.getOriginalFilename();

            //获取当前日期 2021/06/19+文件名 joda-time工具包
            String data = new DateTime().toString("yyyy/MM/dd");
            filename = data+"/"+filename;

            //上传阿里oos
            ossClient.putObject(bucketName, filename, inputStream);

            //返回上传之后文件的路径 需要上传阿里云路径需要手动拼接
            // https://edu-lint.oss-cn-beijing.aliyuncs.com/1.jpg 固定格式
            String url = "https://"+bucketName+"."+endpoint+"/"+filename;
            return url;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            // 关闭OSSClient。
            if(ossClient != null){
                ossClient.shutdown();
            }
        }
    }
}

