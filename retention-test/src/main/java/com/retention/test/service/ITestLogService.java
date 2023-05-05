package com.retention.test.service;

import java.util.List;
import com.retention.test.domain.TestLog;

/**
 * 日志测试Service接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface ITestLogService 
{
    /**
     * 查询日志测试
     * 
     * @param id 日志测试主键
     * @return 日志测试
     */
    public TestLog selectTestLogById(Long id);

    /**
     * 查询日志测试列表
     * 
     * @param testLog 日志测试
     * @return 日志测试集合
     */
    public List<TestLog> selectTestLogList(TestLog testLog);

    /**
     * 新增日志测试
     * 
     * @param testLog 日志测试
     * @return 结果
     */
    public int insertTestLog(TestLog testLog);

    /**
     * 修改日志测试
     * 
     * @param testLog 日志测试
     * @return 结果
     */
    public int updateTestLog(TestLog testLog);

    /**
     * 批量删除日志测试
     * 
     * @param ids 需要删除的日志测试主键集合
     * @return 结果
     */
    public int deleteTestLogByIds(Long[] ids);

    /**
     * 删除日志测试信息
     * 
     * @param id 日志测试主键
     * @return 结果
     */
    public int deleteTestLogById(Long id);
}
