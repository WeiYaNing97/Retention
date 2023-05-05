package com.retention.test.service;

import java.util.List;
import com.retention.test.domain.TestRole;

/**
 * 角色测试Service接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface ITestRoleService 
{
    /**
     * 查询角色测试
     * 
     * @param id 角色测试主键
     * @return 角色测试
     */
    public TestRole selectTestRoleById(Long id);

    /**
     * 查询角色测试列表
     * 
     * @param testRole 角色测试
     * @return 角色测试集合
     */
    public List<TestRole> selectTestRoleList(TestRole testRole);

    /**
     * 新增角色测试
     * 
     * @param testRole 角色测试
     * @return 结果
     */
    public int insertTestRole(TestRole testRole);

    /**
     * 修改角色测试
     * 
     * @param testRole 角色测试
     * @return 结果
     */
    public int updateTestRole(TestRole testRole);

    /**
     * 批量删除角色测试
     * 
     * @param ids 需要删除的角色测试主键集合
     * @return 结果
     */
    public int deleteTestRoleByIds(Long[] ids);

    /**
     * 删除角色测试信息
     * 
     * @param id 角色测试主键
     * @return 结果
     */
    public int deleteTestRoleById(Long id);
}
