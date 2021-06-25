package com.lint.blog.base.exceptionhandler;



import com.lint.blog.base.ResultView.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description : 统一异常处理类
 * @Author : Lint
 * @Date: 2021/6/5 21:28
 */
@ControllerAdvice
@ResponseBody //为了返回数据
@Slf4j
public class GlobalExceptionHandler {

    //指定全局异常类型
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全集异常处理...");
    }

    //指定特定异常类型（除数为0）
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了除数为0...");
    }

    //指定特定异常类型（除数为0）
    @ExceptionHandler(LintException.class)
    public R error(LintException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }


}

