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
import com.retention.test.domain.TestComment;
import com.retention.test.service.ITestCommentService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 评论测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testComment")
public class TestCommentController extends BaseController
{
    @Autowired
    private ITestCommentService testCommentService;

    /**
     * 查询评论测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testComment:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestComment testComment)
    {
        startPage();
        List<TestComment> list = testCommentService.selectTestCommentList(testComment);
        return getDataTable(list);
    }

    /**
     * 导出评论测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testComment:export')")
    @Log(title = "评论测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestComment testComment)
    {
        List<TestComment> list = testCommentService.selectTestCommentList(testComment);
        ExcelUtil<TestComment> util = new ExcelUtil<TestComment>(TestComment.class);
        util.exportExcel(response, list, "评论测试数据");
    }

    /**
     * 获取评论测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testComment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testCommentService.selectTestCommentById(id));
    }

    /**
     * 新增评论测试
     */
    @PreAuthorize("@ss.hasPermi('test:testComment:add')")
    @Log(title = "评论测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestComment testComment)
    {
        return toAjax(testCommentService.insertTestComment(testComment));
    }

    /**
     * 修改评论测试
     */
    @PreAuthorize("@ss.hasPermi('test:testComment:edit')")
    @Log(title = "评论测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestComment testComment)
    {
        return toAjax(testCommentService.updateTestComment(testComment));
    }

    /**
     * 删除评论测试
     */
    @PreAuthorize("@ss.hasPermi('test:testComment:remove')")
    @Log(title = "评论测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testCommentService.deleteTestCommentByIds(ids));
    }
}
