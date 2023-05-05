package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestRoleMapper;
import com.retention.test.domain.TestRole;
import com.retention.test.service.ITestRoleService;

/**
 * 角色测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestRoleServiceImpl implements ITestRoleService 
{
    @Autowired
    private TestRoleMapper testRoleMapper;

    /**
     * 查询角色测试
     * 
     * @param id 角色测试主键
     * @return 角色测试
     */
    @Override
    public TestRole selectTestRoleById(Long id)
    {
        return testRoleMapper.selectTestRoleById(id);
    }

    /**
     * 查询角色测试列表
     * 
     * @param testRole 角色测试
     * @return 角色测试
     */
    @Override
    public List<TestRole> selectTestRoleList(TestRole testRole)
    {
        return testRoleMapper.selectTestRoleList(testRole);
    }

    /**
     * 新增角色测试
     * 
     * @param testRole 角色测试
     * @return 结果
     */
    @Override
    public int insertTestRole(TestRole testRole)
    {
        testRole.setCreateTime(DateUtils.getNowDate());
        return testRoleMapper.insertTestRole(testRole);
    }

    /**
     * 修改角色测试
     * 
     * @param testRole 角色测试
     * @return 结果
     */
    @Override
    public int updateTestRole(TestRole testRole)
    {
        testRole.setUpdateTime(DateUtils.getNowDate());
        return testRoleMapper.updateTestRole(testRole);
    }

    /**
     * 批量删除角色测试
     * 
     * @param ids 需要删除的角色测试主键
     * @return 结果
     */
    @Override
    public int deleteTestRoleByIds(Long[] ids)
    {
        return testRoleMapper.deleteTestRoleByIds(ids);
    }

    /**
     * 删除角色测试信息
     * 
     * @param id 角色测试主键
     * @return 结果
     */
    @Override
    public int deleteTestRoleById(Long id)
    {
        return testRoleMapper.deleteTestRoleById(id);
    }
}
