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
import com.retention.test.domain.TestAd;
import com.retention.test.service.ITestAdService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 广告测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testAd")
public class TestAdController extends BaseController
{
    @Autowired
    private ITestAdService testAdService;

    /**
     * 查询广告测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testAd:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestAd testAd)
    {
        startPage();
        List<TestAd> list = testAdService.selectTestAdList(testAd);
        return getDataTable(list);
    }

    /**
     * 导出广告测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testAd:export')")
    @Log(title = "广告测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestAd testAd)
    {
        List<TestAd> list = testAdService.selectTestAdList(testAd);
        ExcelUtil<TestAd> util = new ExcelUtil<TestAd>(TestAd.class);
        util.exportExcel(response, list, "广告测试数据");
    }

    /**
     * 获取广告测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testAd:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testAdService.selectTestAdById(id));
    }

    /**
     * 新增广告测试
     */
    @PreAuthorize("@ss.hasPermi('test:testAd:add')")
    @Log(title = "广告测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestAd testAd)
    {
        return toAjax(testAdService.insertTestAd(testAd));
    }

    /**
     * 修改广告测试
     */
    @PreAuthorize("@ss.hasPermi('test:testAd:edit')")
    @Log(title = "广告测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestAd testAd)
    {
        return toAjax(testAdService.updateTestAd(testAd));
    }

    /**
     * 删除广告测试
     */
    @PreAuthorize("@ss.hasPermi('test:testAd:remove')")
    @Log(title = "广告测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testAdService.deleteTestAdByIds(ids));
    }
}
