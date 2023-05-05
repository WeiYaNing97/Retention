package com.retention.test.mapper;

import java.util.List;
import com.retention.test.domain.TestPermission;

/**
 * 权限测试Mapper接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface TestPermissionMapper 
{
    /**
     * 查询权限测试
     * 
     * @param id 权限测试主键
     * @return 权限测试
     */
    public TestPermission selectTestPermissionById(Long id);

    /**
     * 查询权限测试列表
     * 
     * @param testPermission 权限测试
     * @return 权限测试集合
     */
    public List<TestPermission> selectTestPermissionList(TestPermission testPermission);

    /**
     * 新增权限测试
     * 
     * @param testPermission 权限测试
     * @return 结果
     */
    public int insertTestPermission(TestPermission testPermission);

    /**
     * 修改权限测试
     * 
     * @param testPermission 权限测试
     * @return 结果
     */
    public int updateTestPermission(TestPermission testPermission);

    /**
     * 删除权限测试
     * 
     * @param id 权限测试主键
     * @return 结果
     */
    public int deleteTestPermissionById(Long id);

    /**
     * 批量删除权限测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestPermissionByIds(Long[] ids);
}
