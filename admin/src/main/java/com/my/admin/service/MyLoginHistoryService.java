package com.my.admin.service;

import com.my.admin.entity.MyLoginHistory;
import java.util.List;

/**
 * 用户登录历史(MyLoginHistory)表服务接口
 *
 * @author lianjie Zhu
 * @since 2020-02-26 17:32:07
 */
public interface MyLoginHistoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param loginId 主键
     * @return 实例对象
     */
    MyLoginHistory queryById(String loginId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyLoginHistory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param myLoginHistory 实例对象
     * @return 实例对象
     */
    MyLoginHistory insert(MyLoginHistory myLoginHistory);

    /**
     * 修改数据
     *
     * @param myLoginHistory 实例对象
     * @return 实例对象
     */
    MyLoginHistory update(MyLoginHistory myLoginHistory);

    /**
     * 通过主键删除数据
     *
     * @param loginId 主键
     * @return 是否成功
     */
    boolean deleteById(String loginId);

}