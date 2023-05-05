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
import com.retention.test.domain.TestMessage;
import com.retention.test.service.ITestMessageService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 消息测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testMessage")
public class TestMessageController extends BaseController
{
    @Autowired
    private ITestMessageService testMessageService;

    /**
     * 查询消息测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testMessage:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestMessage testMessage)
    {
        startPage();
        List<TestMessage> list = testMessageService.selectTestMessageList(testMessage);
        return getDataTable(list);
    }

    /**
     * 导出消息测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testMessage:export')")
    @Log(title = "消息测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestMessage testMessage)
    {
        List<TestMessage> list = testMessageService.selectTestMessageList(testMessage);
        ExcelUtil<TestMessage> util = new ExcelUtil<TestMessage>(TestMessage.class);
        util.exportExcel(response, list, "消息测试数据");
    }

    /**
     * 获取消息测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testMessage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testMessageService.selectTestMessageById(id));
    }

    /**
     * 新增消息测试
     */
    @PreAuthorize("@ss.hasPermi('test:testMessage:add')")
    @Log(title = "消息测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestMessage testMessage)
    {
        return toAjax(testMessageService.insertTestMessage(testMessage));
    }

    /**
     * 修改消息测试
     */
    @PreAuthorize("@ss.hasPermi('test:testMessage:edit')")
    @Log(title = "消息测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestMessage testMessage)
    {
        return toAjax(testMessageService.updateTestMessage(testMessage));
    }

    /**
     * 删除消息测试
     */
    @PreAuthorize("@ss.hasPermi('test:testMessage:remove')")
    @Log(title = "消息测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testMessageService.deleteTestMessageByIds(ids));
    }
}
