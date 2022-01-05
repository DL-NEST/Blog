package com.link.blog.enums;

import lombok.Getter;

/**
  * @apiNote 状态的枚举类
  * @author dl-nest
  * @date 2021/12/1 9:36
 */
@Getter
public enum CodeReturn {

    /*成功状态*/
    SUCCESS(2000,"成功"),

    /*系统异常：4001-1999*/
    SYS_ERROR(4000,"系统异常，请稍后重试"),

    /*参数错误：1001-1999*/
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1003,"参数缺失"),

    /*用户错误：2001-2999*/
    USER_NOT_LOGGED_IN(2001,"用户未登录，请登录后重试"),
    USER_PASSWORD_ERROR(2002,"密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003,"账号已被禁用"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"账号已存在"),
    USER_NUM_LOG(2005,"账户登录已达上限"),

    /*config修改：3000-4000*/
    CONFIG_ERROR(3001,"修改失败");
    //状态码
    private final Integer code;
    //提示信息
    private final String msg;


    CodeReturn(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
