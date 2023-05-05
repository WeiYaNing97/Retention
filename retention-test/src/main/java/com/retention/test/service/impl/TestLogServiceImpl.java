package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestLogMapper;
import com.retention.test.domain.TestLog;
import com.retention.test.service.ITestLogService;

/**
 * 日志测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestLogServiceImpl implements ITestLogService 
{
    @Autowired
    private TestLogMapper testLogMapper;

    /**
     * 查询日志测试
     * 
     * @param id 日志测试主键
     * @return 日志测试
     */
    @Override
    public TestLog selectTestLogById(Long id)
    {
        return testLogMapper.selectTestLogById(id);
    }

    /**
     * 查询日志测试列表
     * 
     * @param testLog 日志测试
     * @return 日志测试
     */
    @Override
    public List<TestLog> selectTestLogList(TestLog testLog)
    {
        return testLogMapper.selectTestLogList(testLog);
    }

    /**
     * 新增日志测试
     * 
     * @param testLog 日志测试
     * @return 结果
     */
    @Override
    public int insertTestLog(TestLog testLog)
    {
        testLog.setCreateTime(DateUtils.getNowDate());
        return testLogMapper.insertTestLog(testLog);
    }

    /**
     * 修改日志测试
     * 
     * @param testLog 日志测试
     * @return 结果
     */
    @Override
    public int updateTestLog(TestLog testLog)
    {
        return testLogMapper.updateTestLog(testLog);
    }

    /**
     * 批量删除日志测试
     * 
     * @param ids 需要删除的日志测试主键
     * @return 结果
     */
    @Override
    public int deleteTestLogByIds(Long[] ids)
    {
        return testLogMapper.deleteTestLogByIds(ids);
    }

    /**
     * 删除日志测试信息
     * 
     * @param id 日志测试主键
     * @return 结果
     */
    @Override
    public int deleteTestLogById(Long id)
    {
        return testLogMapper.deleteTestLogById(id);
    }
}
