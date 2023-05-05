package com.retention.test.service;

import java.util.List;
import com.retention.test.domain.TestOrder;

/**
 * 订单测试Service接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface ITestOrderService 
{
    /**
     * 查询订单测试
     * 
     * @param id 订单测试主键
     * @return 订单测试
     */
    public TestOrder selectTestOrderById(Long id);

    /**
     * 查询订单测试列表
     * 
     * @param testOrder 订单测试
     * @return 订单测试集合
     */
    public List<TestOrder> selectTestOrderList(TestOrder testOrder);

    /**
     * 新增订单测试
     * 
     * @param testOrder 订单测试
     * @return 结果
     */
    public int insertTestOrder(TestOrder testOrder);

    /**
     * 修改订单测试
     * 
     * @param testOrder 订单测试
     * @return 结果
     */
    public int updateTestOrder(TestOrder testOrder);

    /**
     * 批量删除订单测试
     * 
     * @param ids 需要删除的订单测试主键集合
     * @return 结果
     */
    public int deleteTestOrderByIds(Long[] ids);

    /**
     * 删除订单测试信息
     * 
     * @param id 订单测试主键
     * @return 结果
     */
    public int deleteTestOrderById(Long id);
}
