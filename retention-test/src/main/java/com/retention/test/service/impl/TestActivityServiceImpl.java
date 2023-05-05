package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestActivityMapper;
import com.retention.test.domain.TestActivity;
import com.retention.test.service.ITestActivityService;

/**
 * 活动测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestActivityServiceImpl implements ITestActivityService 
{
    @Autowired
    private TestActivityMapper testActivityMapper;

    /**
     * 查询活动测试
     * 
     * @param id 活动测试主键
     * @return 活动测试
     */
    @Override
    public TestActivity selectTestActivityById(Long id)
    {
        return testActivityMapper.selectTestActivityById(id);
    }

    /**
     * 查询活动测试列表
     * 
     * @param testActivity 活动测试
     * @return 活动测试
     */
    @Override
    public List<TestActivity> selectTestActivityList(TestActivity testActivity)
    {
        return testActivityMapper.selectTestActivityList(testActivity);
    }

    /**
     * 新增活动测试
     * 
     * @param testActivity 活动测试
     * @return 结果
     */
    @Override
    public int insertTestActivity(TestActivity testActivity)
    {
        testActivity.setCreateTime(DateUtils.getNowDate());
        return testActivityMapper.insertTestActivity(testActivity);
    }

    /**
     * 修改活动测试
     * 
     * @param testActivity 活动测试
     * @return 结果
     */
    @Override
    public int updateTestActivity(TestActivity testActivity)
    {
        testActivity.setUpdateTime(DateUtils.getNowDate());
        return testActivityMapper.updateTestActivity(testActivity);
    }

    /**
     * 批量删除活动测试
     * 
     * @param ids 需要删除的活动测试主键
     * @return 结果
     */
    @Override
    public int deleteTestActivityByIds(Long[] ids)
    {
        return testActivityMapper.deleteTestActivityByIds(ids);
    }

    /**
     * 删除活动测试信息
     * 
     * @param id 活动测试主键
     * @return 结果
     */
    @Override
    public int deleteTestActivityById(Long id)
    {
        return testActivityMapper.deleteTestActivityById(id);
    }
}
