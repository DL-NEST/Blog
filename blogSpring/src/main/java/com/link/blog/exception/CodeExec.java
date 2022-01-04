package com.link.blog.exception;

import com.link.blog.enums.CodeReturn;

/**
  * @apiNote 自定义异常类
  * @author dl-nest
  * @date 2021/12/2 11:49
 */
public class CodeExec extends RuntimeException {

    private final Integer code;
    //提示信息
    private final String msg;

    public CodeExec(CodeReturn type){
        super(type.getMsg());
        this.code = type.getCode();
        this.msg = type.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
