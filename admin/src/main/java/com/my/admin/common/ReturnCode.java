package com.my.admin.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author lianjie Zhu
 * @Date 2020/2/23 19:16
 * @Version 1.0
 *  代码返回值 code 枚举类
 */
public enum ReturnCode {

    /**
     *  000开头 用户登录
     */
    login_name_error("0001","用户名称不正确"),
    login_phone_error("0002","用户手机号错误"),
    login_email_error("0003","用户邮箱错误"),
    login_password_error("0004","用户密码错误"),
    login_success("0005","登录成功"),


    ;
    private String code;
    private String msg;

    ReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     *  code 值获取 msg
     * @param code
     * @return
     */
    public Map<String,String> getMsg(String code){
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        for (ReturnCode returnCode: ReturnCode.values()) {
            if(returnCode.code.contains(code)){
                hashMap.put(returnCode.code,returnCode.msg);
            }
        }
        return hashMap;
    }


    public Map<String,String> getCode(String msg){
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        for (ReturnCode returnCode:ReturnCode.values()) {
            if(returnCode.msg.contains(msg)){
                hashMap.put(returnCode.code,returnCode.msg);
            }
        }
        return hashMap;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
