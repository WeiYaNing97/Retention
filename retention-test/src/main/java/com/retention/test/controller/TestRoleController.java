package com.retention.test.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.retention.common.annotation.Log;
import com.retention.common.core.controller.BaseController;
import com.retention.common.core.domain.AjaxResult;
import com.retention.common.enums.BusinessType;
import com.retention.test.domain.TestRole;
import com.retention.test.service.ITestRoleService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 角色测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testRole")
public class TestRoleController extends BaseController
{
    @Autowired
    private ITestRoleService testRoleService;

    /**
     * 查询角色测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testRole:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestRole testRole)
    {
        startPage();
        List<TestRole> list = testRoleService.selectTestRoleList(testRole);
        return getDataTable(list);
    }

    /**
     * 导出角色测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testRole:export')")
    @Log(title = "角色测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestRole testRole)
    {
        List<TestRole> list = testRoleService.selectTestRoleList(testRole);
        ExcelUtil<TestRole> util = new ExcelUtil<TestRole>(TestRole.class);
        util.exportExcel(response, list, "角色测试数据");
    }

    /**
     * 获取角色测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testRole:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testRoleService.selectTestRoleById(id));
    }

    /**
     * 新增角色测试
     */
    @PreAuthorize("@ss.hasPermi('test:testRole:add')")
    @Log(title = "角色测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestRole testRole)
    {
        return toAjax(testRoleService.insertTestRole(testRole));
    }

    /**
     * 修改角色测试
     */
    @PreAuthorize("@ss.hasPermi('test:testRole:edit')")
    @Log(title = "角色测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestRole testRole)
    {
        return toAjax(testRoleService.updateTestRole(testRole));
    }

    /**
     * 删除角色测试
     */
    @PreAuthorize("@ss.hasPermi('test:testRole:remove')")
    @Log(title = "角色测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testRoleService.deleteTestRoleByIds(ids));
    }
}
