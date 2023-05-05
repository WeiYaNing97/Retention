package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestCommentMapper;
import com.retention.test.domain.TestComment;
import com.retention.test.service.ITestCommentService;

/**
 * 评论测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestCommentServiceImpl implements ITestCommentService 
{
    @Autowired
    private TestCommentMapper testCommentMapper;

    /**
     * 查询评论测试
     * 
     * @param id 评论测试主键
     * @return 评论测试
     */
    @Override
    public TestComment selectTestCommentById(Long id)
    {
        return testCommentMapper.selectTestCommentById(id);
    }

    /**
     * 查询评论测试列表
     * 
     * @param testComment 评论测试
     * @return 评论测试
     */
    @Override
    public List<TestComment> selectTestCommentList(TestComment testComment)
    {
        return testCommentMapper.selectTestCommentList(testComment);
    }

    /**
     * 新增评论测试
     * 
     * @param testComment 评论测试
     * @return 结果
     */
    @Override
    public int insertTestComment(TestComment testComment)
    {
        testComment.setCreateTime(DateUtils.getNowDate());
        return testCommentMapper.insertTestComment(testComment);
    }

    /**
     * 修改评论测试
     * 
     * @param testComment 评论测试
     * @return 结果
     */
    @Override
    public int updateTestComment(TestComment testComment)
    {
        testComment.setUpdateTime(DateUtils.getNowDate());
        return testCommentMapper.updateTestComment(testComment);
    }

    /**
     * 批量删除评论测试
     * 
     * @param ids 需要删除的评论测试主键
     * @return 结果
     */
    @Override
    public int deleteTestCommentByIds(Long[] ids)
    {
        return testCommentMapper.deleteTestCommentByIds(ids);
    }

    /**
     * 删除评论测试信息
     * 
     * @param id 评论测试主键
     * @return 结果
     */
    @Override
    public int deleteTestCommentById(Long id)
    {
        return testCommentMapper.deleteTestCommentById(id);
    }
}
