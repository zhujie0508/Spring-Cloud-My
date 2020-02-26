package com.my.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户登录历史(MyLoginHistory)实体类
 *
 * @author lianjie Zhu
 * @since 2020-02-26 17:32:06
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyLoginHistory implements Serializable {
    private static final long serialVersionUID = 878328436259172946L;
    /**
    * 登录id
    */
    private String loginId;
    /**
    * 管理员id 或 用户id
    */
    private String loginUserId;
    /**
    * 登录时间
    */
    private Date loginTime;
    /**
    * 登录地址ip
    */
    private String loginIp;
    /**
    * 是否登录成功（0否 1是）
    */
    private String loginIsSuccess;


    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getLoginIsSuccess() {
        return loginIsSuccess;
    }

    public void setLoginIsSuccess(String loginIsSuccess) {
        this.loginIsSuccess = loginIsSuccess;
    }

}