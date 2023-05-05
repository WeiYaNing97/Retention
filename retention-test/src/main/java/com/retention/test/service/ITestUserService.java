package com.retention.test.service;

import java.util.List;
import com.retention.test.domain.TestUser;

/**
 * 用户测试Service接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface ITestUserService 
{
    /**
     * 查询用户测试
     * 
     * @param id 用户测试主键
     * @return 用户测试
     */
    public TestUser selectTestUserById(Long id);

    /**
     * 查询用户测试列表
     * 
     * @param testUser 用户测试
     * @return 用户测试集合
     */
    public List<TestUser> selectTestUserList(TestUser testUser);

    /**
     * 新增用户测试
     * 
     * @param testUser 用户测试
     * @return 结果
     */
    public int insertTestUser(TestUser testUser);

    /**
     * 修改用户测试
     * 
     * @param testUser 用户测试
     * @return 结果
     */
    public int updateTestUser(TestUser testUser);

    /**
     * 批量删除用户测试
     * 
     * @param ids 需要删除的用户测试主键集合
     * @return 结果
     */
    public int deleteTestUserByIds(Long[] ids);

    /**
     * 删除用户测试信息
     * 
     * @param id 用户测试主键
     * @return 结果
     */
    public int deleteTestUserById(Long id);
}
