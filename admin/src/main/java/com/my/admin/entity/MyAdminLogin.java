package com.my.admin.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 管理员用户登录表(MyAdminLogin)实体类
 *
 * @author makejava
 * @since 2020-02-23 12:41:57
 */
public class MyAdminLogin implements Serializable {
    private static final long serialVersionUID = -30297435098305203L;
    /**
    * 管理员主键id
    */
    private String adminId;
    /**
    * 管理员姓名（真实姓名）
    */
    private String adminName;
    /**
    * 管理员登录名称
    */
    private String adminLoginName;
    /**
    * 管理员手机号
    */
    private String adminLoginPhone;
    /**
    * 管理员邮箱
    */
    private String adminLoginEmail;
    /**
    * 管理员密码
    */
    private String adminLoginPassword;
    /**
    * 管理员头像
    */
    private String adminHeadImg;
    /**
    * 管理员年龄
    */
    private String adminAge;
    /**
    * 管理员性别
    */
    private String adminSex;
    /**
    * 管理员账号是否冻结（0否 1是）
    */
    private String adminFreeze;
    /**
    * 管理员昵称
    */
    private String adminNickName;
    /**
    * 管理员账户创建时间
    */
    private Date adminCreateTime;
    /**
    * 管理员账户创建人
    */
    private String adminCreateName;


    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminLoginName() {
        return adminLoginName;
    }

    public void setAdminLoginName(String adminLoginName) {
        this.adminLoginName = adminLoginName;
    }

    public String getAdminLoginPhone() {
        return adminLoginPhone;
    }

    public void setAdminLoginPhone(String adminLoginPhone) {
        this.adminLoginPhone = adminLoginPhone;
    }

    public String getAdminLoginEmail() {
        return adminLoginEmail;
    }

    public void setAdminLoginEmail(String adminLoginEmail) {
        this.adminLoginEmail = adminLoginEmail;
    }

    public String getAdminLoginPassword() {
        return adminLoginPassword;
    }

    public void setAdminLoginPassword(String adminLoginPassword) {
        this.adminLoginPassword = adminLoginPassword;
    }

    public String getAdminHeadImg() {
        return adminHeadImg;
    }

    public void setAdminHeadImg(String adminHeadImg) {
        this.adminHeadImg = adminHeadImg;
    }

    public String getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(String adminAge) {
        this.adminAge = adminAge;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex;
    }

    public String getAdminFreeze() {
        return adminFreeze;
    }

    public void setAdminFreeze(String adminFreeze) {
        this.adminFreeze = adminFreeze;
    }

    public String getAdminNickName() {
        return adminNickName;
    }

    public void setAdminNickName(String adminNickName) {
        this.adminNickName = adminNickName;
    }

    public Date getAdminCreateTime() {
        return adminCreateTime;
    }

    public void setAdminCreateTime(Date adminCreateTime) {
        this.adminCreateTime = adminCreateTime;
    }

    public String getAdminCreateName() {
        return adminCreateName;
    }

    public void setAdminCreateName(String adminCreateName) {
        this.adminCreateName = adminCreateName;
    }
}