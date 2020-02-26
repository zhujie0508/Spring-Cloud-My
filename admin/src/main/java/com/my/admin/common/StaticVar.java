package com.my.admin.common;


/**
 * @Author lianjie Zhu
 * @Date 2020/2/26 17:33
 * @Version 1.0
 *  全局静态变量 类
 */
public class StaticVar {
    /**
     *  0否 1是 全局静态变量
     */
    public static String No = "0";
    public static String Yes = "1";

    /**
     *  jwt 加密 密钥
     */
    public static String JwtSalt = "0508";
    public static String JwtName = "My";

    /**
     * 存入 header 中的 token 键值名称
     */
    public static String TokenName = "token";
}
