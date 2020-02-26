package com.my.admin.dao;

import com.my.admin.entity.MyLoginHistory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 用户登录历史(MyLoginHistory)表数据库访问层
 *
 * @author lianjie Zhu
 * @since 2020-02-26 17:32:07
 */
 @Mapper
public interface MyLoginHistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param loginId 主键
     * @return 实例对象
     */
    MyLoginHistory queryById(String loginId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyLoginHistory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param myLoginHistory 实例对象
     * @return 对象列表
     */
    List<MyLoginHistory> queryAll(MyLoginHistory myLoginHistory);

    /**
     * 新增数据
     *
     * @param myLoginHistory 实例对象
     * @return 影响行数
     */
    int insert(MyLoginHistory myLoginHistory);

    /**
     * 修改数据
     *
     * @param myLoginHistory 实例对象
     * @return 影响行数
     */
    int update(MyLoginHistory myLoginHistory);

    /**
     * 通过主键删除数据
     *
     * @param loginId 主键
     * @return 影响行数
     */
    int deleteById(String loginId);

}