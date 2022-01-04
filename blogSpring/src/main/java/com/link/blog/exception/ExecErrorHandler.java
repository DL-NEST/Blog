package com.link.blog.exception;

import com.link.blog.result.R;
import com.link.blog.util.RUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
  * @apiNote 异常处理类
  * @author dl-nest
  * @date 2021/12/1 8:49
 */
@Slf4j
@ControllerAdvice
public class ExecErrorHandler {
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e){
        log.warn("全局异常捕获>>>:"+e);
        return "全局异常捕获,错误原因>>>"+e.getMessage();
    }

    /**
      * @param e
      * @return r(json)
      * @apiNote 请求错误的异常返回函数
      * @author dl-nest
      * @date 2021/12/2 16:55
     */
    @ExceptionHandler(value = CodeExec.class)
    @ResponseBody
    public R CodeHandler(CodeExec e){
        log.warn("请求错误码"+e.getCode()+"->>错误信息："+e.getMsg());
        return RUtils.Error(e.getCode(),e.getMsg());
    }
}
