package com.retention.test.service;

import java.util.List;
import com.retention.test.domain.TestActivity;

/**
 * 活动测试Service接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface ITestActivityService 
{
    /**
     * 查询活动测试
     * 
     * @param id 活动测试主键
     * @return 活动测试
     */
    public TestActivity selectTestActivityById(Long id);

    /**
     * 查询活动测试列表
     * 
     * @param testActivity 活动测试
     * @return 活动测试集合
     */
    public List<TestActivity> selectTestActivityList(TestActivity testActivity);

    /**
     * 新增活动测试
     * 
     * @param testActivity 活动测试
     * @return 结果
     */
    public int insertTestActivity(TestActivity testActivity);

    /**
     * 修改活动测试
     * 
     * @param testActivity 活动测试
     * @return 结果
     */
    public int updateTestActivity(TestActivity testActivity);

    /**
     * 批量删除活动测试
     * 
     * @param ids 需要删除的活动测试主键集合
     * @return 结果
     */
    public int deleteTestActivityByIds(Long[] ids);

    /**
     * 删除活动测试信息
     * 
     * @param id 活动测试主键
     * @return 结果
     */
    public int deleteTestActivityById(Long id);
}
