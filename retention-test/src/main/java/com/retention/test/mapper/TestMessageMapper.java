package com.retention.test.mapper;

import java.util.List;
import com.retention.test.domain.TestMessage;

/**
 * 消息测试Mapper接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface TestMessageMapper 
{
    /**
     * 查询消息测试
     * 
     * @param id 消息测试主键
     * @return 消息测试
     */
    public TestMessage selectTestMessageById(Long id);

    /**
     * 查询消息测试列表
     * 
     * @param testMessage 消息测试
     * @return 消息测试集合
     */
    public List<TestMessage> selectTestMessageList(TestMessage testMessage);

    /**
     * 新增消息测试
     * 
     * @param testMessage 消息测试
     * @return 结果
     */
    public int insertTestMessage(TestMessage testMessage);

    /**
     * 修改消息测试
     * 
     * @param testMessage 消息测试
     * @return 结果
     */
    public int updateTestMessage(TestMessage testMessage);

    /**
     * 删除消息测试
     * 
     * @param id 消息测试主键
     * @return 结果
     */
    public int deleteTestMessageById(Long id);

    /**
     * 批量删除消息测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestMessageByIds(Long[] ids);
}
