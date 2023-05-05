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
import com.retention.test.domain.TestUser;
import com.retention.test.service.ITestUserService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 用户测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testUser")
public class TestUserController extends BaseController
{
    @Autowired
    private ITestUserService testUserService;

    /**
     * 查询用户测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestUser testUser)
    {
        startPage();
        List<TestUser> list = testUserService.selectTestUserList(testUser);
        return getDataTable(list);
    }

    /**
     * 导出用户测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testUser:export')")
    @Log(title = "用户测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestUser testUser)
    {
        List<TestUser> list = testUserService.selectTestUserList(testUser);
        ExcelUtil<TestUser> util = new ExcelUtil<TestUser>(TestUser.class);
        util.exportExcel(response, list, "用户测试数据");
    }

    /**
     * 获取用户测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testUserService.selectTestUserById(id));
    }

    /**
     * 新增用户测试
     */
    @PreAuthorize("@ss.hasPermi('test:testUser:add')")
    @Log(title = "用户测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestUser testUser)
    {
        return toAjax(testUserService.insertTestUser(testUser));
    }

    /**
     * 修改用户测试
     */
    @PreAuthorize("@ss.hasPermi('test:testUser:edit')")
    @Log(title = "用户测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestUser testUser)
    {
        return toAjax(testUserService.updateTestUser(testUser));
    }

    /**
     * 删除用户测试
     */
    @PreAuthorize("@ss.hasPermi('test:testUser:remove')")
    @Log(title = "用户测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testUserService.deleteTestUserByIds(ids));
    }
}
