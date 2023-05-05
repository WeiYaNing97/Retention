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
import com.retention.test.domain.TestLog;
import com.retention.test.service.ITestLogService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 日志测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testLog")
public class TestLogController extends BaseController
{
    @Autowired
    private ITestLogService testLogService;

    /**
     * 查询日志测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testLog:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestLog testLog)
    {
        startPage();
        List<TestLog> list = testLogService.selectTestLogList(testLog);
        return getDataTable(list);
    }

    /**
     * 导出日志测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testLog:export')")
    @Log(title = "日志测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestLog testLog)
    {
        List<TestLog> list = testLogService.selectTestLogList(testLog);
        ExcelUtil<TestLog> util = new ExcelUtil<TestLog>(TestLog.class);
        util.exportExcel(response, list, "日志测试数据");
    }

    /**
     * 获取日志测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testLog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testLogService.selectTestLogById(id));
    }

    /**
     * 新增日志测试
     */
    @PreAuthorize("@ss.hasPermi('test:testLog:add')")
    @Log(title = "日志测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestLog testLog)
    {
        return toAjax(testLogService.insertTestLog(testLog));
    }

    /**
     * 修改日志测试
     */
    @PreAuthorize("@ss.hasPermi('test:testLog:edit')")
    @Log(title = "日志测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestLog testLog)
    {
        return toAjax(testLogService.updateTestLog(testLog));
    }

    /**
     * 删除日志测试
     */
    @PreAuthorize("@ss.hasPermi('test:testLog:remove')")
    @Log(title = "日志测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testLogService.deleteTestLogByIds(ids));
    }
}
