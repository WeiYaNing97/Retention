package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestPermissionMapper;
import com.retention.test.domain.TestPermission;
import com.retention.test.service.ITestPermissionService;

/**
 * 权限测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestPermissionServiceImpl implements ITestPermissionService 
{
    @Autowired
    private TestPermissionMapper testPermissionMapper;

    /**
     * 查询权限测试
     * 
     * @param id 权限测试主键
     * @return 权限测试
     */
    @Override
    public TestPermission selectTestPermissionById(Long id)
    {
        return testPermissionMapper.selectTestPermissionById(id);
    }

    /**
     * 查询权限测试列表
     * 
     * @param testPermission 权限测试
     * @return 权限测试
     */
    @Override
    public List<TestPermission> selectTestPermissionList(TestPermission testPermission)
    {
        return testPermissionMapper.selectTestPermissionList(testPermission);
    }

    /**
     * 新增权限测试
     * 
     * @param testPermission 权限测试
     * @return 结果
     */
    @Override
    public int insertTestPermission(TestPermission testPermission)
    {
        testPermission.setCreateTime(DateUtils.getNowDate());
        return testPermissionMapper.insertTestPermission(testPermission);
    }

    /**
     * 修改权限测试
     * 
     * @param testPermission 权限测试
     * @return 结果
     */
    @Override
    public int updateTestPermission(TestPermission testPermission)
    {
        testPermission.setUpdateTime(DateUtils.getNowDate());
        return testPermissionMapper.updateTestPermission(testPermission);
    }

    /**
     * 批量删除权限测试
     * 
     * @param ids 需要删除的权限测试主键
     * @return 结果
     */
    @Override
    public int deleteTestPermissionByIds(Long[] ids)
    {
        return testPermissionMapper.deleteTestPermissionByIds(ids);
    }

    /**
     * 删除权限测试信息
     * 
     * @param id 权限测试主键
     * @return 结果
     */
    @Override
    public int deleteTestPermissionById(Long id)
    {
        return testPermissionMapper.deleteTestPermissionById(id);
    }
}
