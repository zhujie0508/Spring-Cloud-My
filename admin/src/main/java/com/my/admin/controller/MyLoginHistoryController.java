package com.my.admin.controller;

import com.my.admin.entity.MyLoginHistory;
import com.my.admin.service.MyLoginHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户登录历史(MyLoginHistory)表控制层
 *
 * @author lianjie Zhu
 * @since 2020-02-26 17:32:08
 */
@RestController
@RequestMapping("myLoginHistory")
public class MyLoginHistoryController {
    /**
     * 服务对象
     */
    @Resource
    private MyLoginHistoryService myLoginHistoryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MyLoginHistory selectOne(String id) {
        return this.myLoginHistoryService.queryById(id);
    }

}