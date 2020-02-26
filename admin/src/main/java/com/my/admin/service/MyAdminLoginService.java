package com.my.admin.service;

import com.my.admin.common.ResultMap;
import com.my.admin.entity.MyAdminLogin;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员用户登录表(MyAdminLogin)表服务接口
 *
 * @author makejava
 * @since 2020-02-23 12:41:58
 */
public interface MyAdminLoginService {

    /**
     *  管理员登录
     * @param loginName 登录名称
     * @param loginPassword 登录密码
     * @param response 响应对象
     * @return  ResultMap
     */
    ResultMap adminLogin(String loginName , String loginPassword, HttpServletResponse response);


}