package com.retention.test.mapper;

import java.util.List;
import com.retention.test.domain.TestComment;

/**
 * 评论测试Mapper接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface TestCommentMapper 
{
    /**
     * 查询评论测试
     * 
     * @param id 评论测试主键
     * @return 评论测试
     */
    public TestComment selectTestCommentById(Long id);

    /**
     * 查询评论测试列表
     * 
     * @param testComment 评论测试
     * @return 评论测试集合
     */
    public List<TestComment> selectTestCommentList(TestComment testComment);

    /**
     * 新增评论测试
     * 
     * @param testComment 评论测试
     * @return 结果
     */
    public int insertTestComment(TestComment testComment);

    /**
     * 修改评论测试
     * 
     * @param testComment 评论测试
     * @return 结果
     */
    public int updateTestComment(TestComment testComment);

    /**
     * 删除评论测试
     * 
     * @param id 评论测试主键
     * @return 结果
     */
    public int deleteTestCommentById(Long id);

    /**
     * 批量删除评论测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestCommentByIds(Long[] ids);
}
