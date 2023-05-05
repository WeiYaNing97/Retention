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
import com.retention.test.domain.TestActivity;
import com.retention.test.service.ITestActivityService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 活动测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testActivity")
public class TestActivityController extends BaseController
{
    @Autowired
    private ITestActivityService testActivityService;

    /**
     * 查询活动测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testActivity:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestActivity testActivity)
    {
        startPage();
        List<TestActivity> list = testActivityService.selectTestActivityList(testActivity);
        return getDataTable(list);
    }

    /**
     * 导出活动测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testActivity:export')")
    @Log(title = "活动测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestActivity testActivity)
    {
        List<TestActivity> list = testActivityService.selectTestActivityList(testActivity);
        ExcelUtil<TestActivity> util = new ExcelUtil<TestActivity>(TestActivity.class);
        util.exportExcel(response, list, "活动测试数据");
    }

    /**
     * 获取活动测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testActivity:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testActivityService.selectTestActivityById(id));
    }

    /**
     * 新增活动测试
     */
    @PreAuthorize("@ss.hasPermi('test:testActivity:add')")
    @Log(title = "活动测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestActivity testActivity)
    {
        return toAjax(testActivityService.insertTestActivity(testActivity));
    }

    /**
     * 修改活动测试
     */
    @PreAuthorize("@ss.hasPermi('test:testActivity:edit')")
    @Log(title = "活动测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestActivity testActivity)
    {
        return toAjax(testActivityService.updateTestActivity(testActivity));
    }

    /**
     * 删除活动测试
     */
    @PreAuthorize("@ss.hasPermi('test:testActivity:remove')")
    @Log(title = "活动测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testActivityService.deleteTestActivityByIds(ids));
    }
}
