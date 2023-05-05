package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestAdMapper;
import com.retention.test.domain.TestAd;
import com.retention.test.service.ITestAdService;

/**
 * 广告测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestAdServiceImpl implements ITestAdService 
{
    @Autowired
    private TestAdMapper testAdMapper;

    /**
     * 查询广告测试
     * 
     * @param id 广告测试主键
     * @return 广告测试
     */
    @Override
    public TestAd selectTestAdById(Long id)
    {
        return testAdMapper.selectTestAdById(id);
    }

    /**
     * 查询广告测试列表
     * 
     * @param testAd 广告测试
     * @return 广告测试
     */
    @Override
    public List<TestAd> selectTestAdList(TestAd testAd)
    {
        return testAdMapper.selectTestAdList(testAd);
    }

    /**
     * 新增广告测试
     * 
     * @param testAd 广告测试
     * @return 结果
     */
    @Override
    public int insertTestAd(TestAd testAd)
    {
        testAd.setCreateTime(DateUtils.getNowDate());
        return testAdMapper.insertTestAd(testAd);
    }

    /**
     * 修改广告测试
     * 
     * @param testAd 广告测试
     * @return 结果
     */
    @Override
    public int updateTestAd(TestAd testAd)
    {
        testAd.setUpdateTime(DateUtils.getNowDate());
        return testAdMapper.updateTestAd(testAd);
    }

    /**
     * 批量删除广告测试
     * 
     * @param ids 需要删除的广告测试主键
     * @return 结果
     */
    @Override
    public int deleteTestAdByIds(Long[] ids)
    {
        return testAdMapper.deleteTestAdByIds(ids);
    }

    /**
     * 删除广告测试信息
     * 
     * @param id 广告测试主键
     * @return 结果
     */
    @Override
    public int deleteTestAdById(Long id)
    {
        return testAdMapper.deleteTestAdById(id);
    }
}
