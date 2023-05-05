package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestMessageMapper;
import com.retention.test.domain.TestMessage;
import com.retention.test.service.ITestMessageService;

/**
 * 消息测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestMessageServiceImpl implements ITestMessageService 
{
    @Autowired
    private TestMessageMapper testMessageMapper;

    /**
     * 查询消息测试
     * 
     * @param id 消息测试主键
     * @return 消息测试
     */
    @Override
    public TestMessage selectTestMessageById(Long id)
    {
        return testMessageMapper.selectTestMessageById(id);
    }

    /**
     * 查询消息测试列表
     * 
     * @param testMessage 消息测试
     * @return 消息测试
     */
    @Override
    public List<TestMessage> selectTestMessageList(TestMessage testMessage)
    {
        return testMessageMapper.selectTestMessageList(testMessage);
    }

    /**
     * 新增消息测试
     * 
     * @param testMessage 消息测试
     * @return 结果
     */
    @Override
    public int insertTestMessage(TestMessage testMessage)
    {
        testMessage.setCreateTime(DateUtils.getNowDate());
        return testMessageMapper.insertTestMessage(testMessage);
    }

    /**
     * 修改消息测试
     * 
     * @param testMessage 消息测试
     * @return 结果
     */
    @Override
    public int updateTestMessage(TestMessage testMessage)
    {
        testMessage.setUpdateTime(DateUtils.getNowDate());
        return testMessageMapper.updateTestMessage(testMessage);
    }

    /**
     * 批量删除消息测试
     * 
     * @param ids 需要删除的消息测试主键
     * @return 结果
     */
    @Override
    public int deleteTestMessageByIds(Long[] ids)
    {
        return testMessageMapper.deleteTestMessageByIds(ids);
    }

    /**
     * 删除消息测试信息
     * 
     * @param id 消息测试主键
     * @return 结果
     */
    @Override
    public int deleteTestMessageById(Long id)
    {
        return testMessageMapper.deleteTestMessageById(id);
    }
}
