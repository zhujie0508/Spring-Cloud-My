package com.my.admin.controller;

import com.my.admin.common.ResultMap;
import com.my.admin.entity.MyAdminLogin;
import com.my.admin.service.MyAdminLoginService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * 管理员用户登录表(MyAdminLogin)表控制层
 *
 * @author makejava
 * @since 2020-02-23 12:41:59
 */
@RestController
@RequestMapping("myAdminLogin")
@Slf4j
@Validated
public class MyAdminLoginController {
    /**
     * 服务对象
     */
    @Autowired
    private MyAdminLoginService myAdminLoginService;

    @RequestMapping("v1/adminLogin")
    @ResponseBody
    public ResultMap adminLogin(@NotBlank(message = "用户名不能为空") @RequestParam("loginName")String loginName ,
                                @NotBlank(message = "密码不能为空") @RequestParam("loginPassword")String loginPassword,
                                HttpServletResponse response){

        ResultMap resultMap = new ResultMap();

        try {
             resultMap = myAdminLoginService.adminLogin(loginName, loginPassword,response);
        }catch (Exception e){
            log.error("登录失败{getMessage}"+e.getMessage());
            log.error("登录失败{getLocalizedMessage}"+e.getLocalizedMessage());
        }

        return resultMap;
    }

}