package com.my.admin.common;

import lombok.*;

import java.util.Map;

/**
 * @Author lianjie Zhu
 * @Date 2020/2/23 18:21
 * @Version 1.0
 *  返回的结果集
 */
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultMap {
    /**
     * 返回代码code
      */
    private String code;
    /**
     *  返回的结果集
     */
    private Map result;
    /**
     * 返回的提示信息
     */
    private String msg;

    /**
     * 抛出的异常
     */
    private String error;
}
