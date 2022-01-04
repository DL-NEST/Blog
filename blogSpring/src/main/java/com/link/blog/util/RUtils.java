package com.link.blog.util;

import com.link.blog.result.R;
import com.link.blog.enums.CodeReturn;


public class RUtils {
    public static R success(Object result) {
        R r = new R();
        r.setCode(CodeReturn.SUCCESS.getCode());
        r.setMsg(CodeReturn.SUCCESS.getMsg());
        r.setData(result);
        return r;
    }
    //成功，但返回体没数据
    public static R success(){
        return success(null);
    }
    //失败返回信息
    public static R Error(Integer code,String msg){
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }
}
