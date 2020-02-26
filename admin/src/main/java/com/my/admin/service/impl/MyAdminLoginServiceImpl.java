package com.my.admin.service.impl;

import com.my.admin.common.CheckingUtil;
import com.my.admin.common.ResultMap;
import com.my.admin.common.ReturnCode;
import com.my.admin.common.StaticVar;
import com.my.admin.entity.MyAdminLogin;
import com.my.admin.dao.MyAdminLoginDao;
import com.my.admin.entity.MyLoginHistory;
import com.my.admin.service.MyAdminLoginService;
import com.my.admin.service.MyLoginHistoryService;
import com.my.admin.util.JwtUtil;
import com.my.admin.util.RedisUtil;
import com.my.admin.util.UserIP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

import static com.my.admin.common.CheckingUtil.checkLoginName;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * 管理员用户登录表(MyAdminLogin)表服务实现类
 *
 * @author makejava
 * @since 2020-02-23 12:41:59
 */
@Service("myAdminLoginService")
@Slf4j(topic = "admin登录service-->")
public class MyAdminLoginServiceImpl implements MyAdminLoginService {

    /**
     *     管理员信息 mapper
     */
    @Resource
    private MyAdminLoginDao myAdminLoginDao;

    /**
     *  redis
     */
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 登录历史 service
     */
    @Autowired
    private MyLoginHistoryService myLoginHistoryService;


    @Override
    @Transactional(propagation=REQUIRED,rollbackFor = Exception.class)
    public ResultMap adminLogin(String loginName, String loginPassword,HttpServletResponse response) {

        ResultMap resultMap = new ResultMap();
        Integer nameType = checkLoginName(loginName);
        MyAdminLogin myAdminLogin = myAdminLoginDao.getLoginName(loginName, nameType );

//        用户登录历史
        MyLoginHistory myLoginHistory = new MyLoginHistory();
        myLoginHistory.setLoginTime(new Date());    //登录时间
        myLoginHistory.setLoginIp(UserIP.getUserIP());  //登录IP地址

        if(null == myAdminLogin) {
            myLoginHistory.setLoginIsSuccess(StaticVar.No); //是否登录成功
            switch (nameType){
                case 1 :
                    myLoginHistory.setLoginUserId(ReturnCode.login_name_error.getMsg());
                    myLoginHistoryService.insert(myLoginHistory);

                    log.error(ReturnCode.login_name_error.getMsg());
                    resultMap.setCode(ReturnCode.login_name_error.getCode());
                    resultMap.setMsg(ReturnCode.login_name_error.getMsg());
                    break;
                case 2:
                    myLoginHistory.setLoginUserId(ReturnCode.login_phone_error.getMsg());
                    myLoginHistoryService.insert(myLoginHistory);

                    log.error(ReturnCode.login_phone_error.getMsg());
                    resultMap.setCode(ReturnCode.login_phone_error.getCode());
                    resultMap.setMsg(ReturnCode.login_phone_error.getMsg());
                    break;
                case 3:
                    myLoginHistory.setLoginUserId(ReturnCode.login_email_error.getMsg());
                    myLoginHistoryService.insert(myLoginHistory);

                    log.error(ReturnCode.login_email_error.getMsg());
                    resultMap.setCode(ReturnCode.login_email_error.getCode());
                    resultMap.setMsg(ReturnCode.login_email_error.getMsg());
                    break;
            }
            return resultMap;
        }else {
            if(!loginPassword.trim().equals(myAdminLogin.getAdminLoginPassword())){
                myLoginHistory.setLoginIsSuccess(StaticVar.No); //是否登录成功
                myLoginHistory.setLoginUserId(myAdminLogin.getAdminId());
                myLoginHistoryService.insert(myLoginHistory);

                log.error("用户{}密码错误",loginName);
                resultMap.setCode(ReturnCode.login_password_error.getCode());
                resultMap.setMsg(ReturnCode.login_password_error.getMsg());
                return resultMap;
            }else {

                myLoginHistory.setLoginIsSuccess(StaticVar.Yes); //是否登录成功
                myLoginHistory.setLoginUserId(myAdminLogin.getAdminId());
                myLoginHistoryService.insert(myLoginHistory);

//                生成token  存入redis
                String token = JwtUtil.cteateToken(myAdminLogin.getAdminId(), myAdminLogin.getAdminName());
                redisUtil.opsForValue().set(loginName,token);
//                将token 存入 header 中
                response.setHeader(StaticVar.TokenName,token);

                log.info("用户{}登录成功",loginName);
                resultMap.setCode(ReturnCode.login_success.getCode());
                resultMap.setMsg(ReturnCode.login_success.getMsg());
                return resultMap;
            }
        }
    }
}