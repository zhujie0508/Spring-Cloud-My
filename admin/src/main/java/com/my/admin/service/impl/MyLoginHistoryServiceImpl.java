package com.my.admin.service.impl;

import com.my.admin.entity.MyLoginHistory;
import com.my.admin.dao.MyLoginHistoryDao;
import com.my.admin.service.MyLoginHistoryService;
import com.my.admin.util.PrimarykeyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 用户登录历史(MyLoginHistory)表服务实现类
 *
 * @author lianjie Zhu
 * @since 2020-02-26 17:32:07
 */
@Service("myLoginHistoryService")
public class MyLoginHistoryServiceImpl implements MyLoginHistoryService {
    @Resource
    private MyLoginHistoryDao myLoginHistoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param loginId 主键
     * @return 实例对象
     */
    @Override
    public MyLoginHistory queryById(String loginId) {
        return this.myLoginHistoryDao.queryById(loginId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MyLoginHistory> queryAllByLimit(int offset, int limit) {
        return this.myLoginHistoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param myLoginHistory 实例对象
     * @return 实例对象
     */
    @Override
    public MyLoginHistory insert(MyLoginHistory myLoginHistory) {
        myLoginHistory.setLoginId(PrimarykeyUtil.get32Id());
        this.myLoginHistoryDao.insert(myLoginHistory);
        return myLoginHistory;
    }

    /**
     * 修改数据
     *
     * @param myLoginHistory 实例对象
     * @return 实例对象
     */
    @Override
    public MyLoginHistory update(MyLoginHistory myLoginHistory) {
        this.myLoginHistoryDao.update(myLoginHistory);
        return this.queryById(myLoginHistory.getLoginId());
    }

    /**
     * 通过主键删除数据
     *
     * @param loginId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String loginId) {
        return this.myLoginHistoryDao.deleteById(loginId) > 0;
    }
}