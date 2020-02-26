package com.my.admin.util;

import java.util.UUID;

/**
 * @Author lianjie Zhu
 * @Date 2020/2/26 18:34
 * @Version 1.0
 *  主键id 生成类
 */
public class PrimarykeyUtil {

    /**
     *      获取32位id 的方法
     *      todo  算法生成 暂时先这么用着
     * @return
     */
    public static String get32Id(){
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}
