package com.lint.blog.base.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description : 自定义异常类
 * @Author : Lint
 * @Date: 2021/6/5 21:45
 */
@Data
@AllArgsConstructor//生成有参构造
@NoArgsConstructor//生成无参构造
public class LintException extends RuntimeException {

    private Integer code;//状态码
    private String msg;//异常描述

}

