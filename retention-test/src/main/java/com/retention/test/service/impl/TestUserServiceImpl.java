package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestUserMapper;
import com.retention.test.domain.TestUser;
import com.retention.test.service.ITestUserService;

/**
 * 用户测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestUserServiceImpl implements ITestUserService 
{
    @Autowired
    private TestUserMapper testUserMapper;

    /**
     * 查询用户测试
     * 
     * @param id 用户测试主键
     * @return 用户测试
     */
    @Override
    public TestUser selectTestUserById(Long id)
    {
        return testUserMapper.selectTestUserById(id);
    }

    /**
     * 查询用户测试列表
     * 
     * @param testUser 用户测试
     * @return 用户测试
     */
    @Override
    public List<TestUser> selectTestUserList(TestUser testUser)
    {
        return testUserMapper.selectTestUserList(testUser);
    }

    /**
     * 新增用户测试
     * 
     * @param testUser 用户测试
     * @return 结果
     */
    @Override
    public int insertTestUser(TestUser testUser)
    {
        return testUserMapper.insertTestUser(testUser);
    }

    /**
     * 修改用户测试
     * 
     * @param testUser 用户测试
     * @return 结果
     */
    @Override
    public int updateTestUser(TestUser testUser)
    {
        testUser.setUpdateTime(DateUtils.getNowDate());
        return testUserMapper.updateTestUser(testUser);
    }

    /**
     * 批量删除用户测试
     * 
     * @param ids 需要删除的用户测试主键
     * @return 结果
     */
    @Override
    public int deleteTestUserByIds(Long[] ids)
    {
        return testUserMapper.deleteTestUserByIds(ids);
    }

    /**
     * 删除用户测试信息
     * 
     * @param id 用户测试主键
     * @return 结果
     */
    @Override
    public int deleteTestUserById(Long id)
    {
        return testUserMapper.deleteTestUserById(id);
    }
}
