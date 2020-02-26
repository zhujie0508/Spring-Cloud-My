package com.my.admin.dao;

import com.my.admin.entity.MyAdminLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 管理员用户登录表(MyAdminLogin)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-23 12:41:58
 */
@Mapper
public interface MyAdminLoginDao {

    /**
     * 通过ID查询单条数据
     *
     * @param adminId 主键
     * @return 实例对象
     */
    MyAdminLogin queryById(String adminId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MyAdminLogin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param myAdminLogin 实例对象
     * @return 对象列表
     */
    List<MyAdminLogin> queryAll(MyAdminLogin myAdminLogin);

    /**
     * 新增数据
     *
     * @param myAdminLogin 实例对象
     * @return 影响行数
     */
    int insert(MyAdminLogin myAdminLogin);

    /**
     * 修改数据
     *
     * @param myAdminLogin 实例对象
     * @return 影响行数
     */
    int update(MyAdminLogin myAdminLogin);

    /**
     * 通过主键删除数据
     *
     * @param adminId 主键
     * @return 影响行数
     */
    int deleteById(String adminId);

    /**
     * 根据用户登录名称 获取用户密码
     * @param loginName 用户名称
     * @param nameType 用户名称类型(1账户登录 2手机号登录 3邮箱登录)
     * @return
     */
    MyAdminLogin getLoginName(@Param("loginName") String loginName, @Param("nameType") Integer nameType);

}