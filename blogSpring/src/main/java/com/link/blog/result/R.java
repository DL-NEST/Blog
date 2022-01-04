package com.link.blog.result;

import lombok.Data;

@Data
public class R {
    /*返回数据的结构*/
    private  Integer code;
    private String msg;
    private Object data;

    public void setData(Object result) {
        this.data = result;
    }
}
