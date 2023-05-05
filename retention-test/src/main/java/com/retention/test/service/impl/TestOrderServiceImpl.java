package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestOrderMapper;
import com.retention.test.domain.TestOrder;
import com.retention.test.service.ITestOrderService;

/**
 * 订单测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestOrderServiceImpl implements ITestOrderService 
{
    @Autowired
    private TestOrderMapper testOrderMapper;

    /**
     * 查询订单测试
     * 
     * @param id 订单测试主键
     * @return 订单测试
     */
    @Override
    public TestOrder selectTestOrderById(Long id)
    {
        return testOrderMapper.selectTestOrderById(id);
    }

    /**
     * 查询订单测试列表
     * 
     * @param testOrder 订单测试
     * @return 订单测试
     */
    @Override
    public List<TestOrder> selectTestOrderList(TestOrder testOrder)
    {
        return testOrderMapper.selectTestOrderList(testOrder);
    }

    /**
     * 新增订单测试
     * 
     * @param testOrder 订单测试
     * @return 结果
     */
    @Override
    public int insertTestOrder(TestOrder testOrder)
    {
        testOrder.setCreateTime(DateUtils.getNowDate());
        return testOrderMapper.insertTestOrder(testOrder);
    }

    /**
     * 修改订单测试
     * 
     * @param testOrder 订单测试
     * @return 结果
     */
    @Override
    public int updateTestOrder(TestOrder testOrder)
    {
        testOrder.setUpdateTime(DateUtils.getNowDate());
        return testOrderMapper.updateTestOrder(testOrder);
    }

    /**
     * 批量删除订单测试
     * 
     * @param ids 需要删除的订单测试主键
     * @return 结果
     */
    @Override
    public int deleteTestOrderByIds(Long[] ids)
    {
        return testOrderMapper.deleteTestOrderByIds(ids);
    }

    /**
     * 删除订单测试信息
     * 
     * @param id 订单测试主键
     * @return 结果
     */
    @Override
    public int deleteTestOrderById(Long id)
    {
        return testOrderMapper.deleteTestOrderById(id);
    }
}
