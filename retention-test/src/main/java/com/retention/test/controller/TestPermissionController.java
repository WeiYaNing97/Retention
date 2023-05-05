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
import com.retention.test.domain.TestPermission;
import com.retention.test.service.ITestPermissionService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 权限测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testPermission")
public class TestPermissionController extends BaseController
{
    @Autowired
    private ITestPermissionService testPermissionService;

    /**
     * 查询权限测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testPermission:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestPermission testPermission)
    {
        startPage();
        List<TestPermission> list = testPermissionService.selectTestPermissionList(testPermission);
        return getDataTable(list);
    }

    /**
     * 导出权限测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testPermission:export')")
    @Log(title = "权限测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestPermission testPermission)
    {
        List<TestPermission> list = testPermissionService.selectTestPermissionList(testPermission);
        ExcelUtil<TestPermission> util = new ExcelUtil<TestPermission>(TestPermission.class);
        util.exportExcel(response, list, "权限测试数据");
    }

    /**
     * 获取权限测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testPermission:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testPermissionService.selectTestPermissionById(id));
    }

    /**
     * 新增权限测试
     */
    @PreAuthorize("@ss.hasPermi('test:testPermission:add')")
    @Log(title = "权限测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestPermission testPermission)
    {
        return toAjax(testPermissionService.insertTestPermission(testPermission));
    }

    /**
     * 修改权限测试
     */
    @PreAuthorize("@ss.hasPermi('test:testPermission:edit')")
    @Log(title = "权限测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestPermission testPermission)
    {
        return toAjax(testPermissionService.updateTestPermission(testPermission));
    }

    /**
     * 删除权限测试
     */
    @PreAuthorize("@ss.hasPermi('test:testPermission:remove')")
    @Log(title = "权限测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testPermissionService.deleteTestPermissionByIds(ids));
    }
}
