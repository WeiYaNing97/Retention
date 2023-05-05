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
import com.retention.test.domain.TestOrder;
import com.retention.test.service.ITestOrderService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 订单测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testOrder")
public class TestOrderController extends BaseController
{
    @Autowired
    private ITestOrderService testOrderService;

    /**
     * 查询订单测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testOrder:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestOrder testOrder)
    {
        startPage();
        List<TestOrder> list = testOrderService.selectTestOrderList(testOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testOrder:export')")
    @Log(title = "订单测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestOrder testOrder)
    {
        List<TestOrder> list = testOrderService.selectTestOrderList(testOrder);
        ExcelUtil<TestOrder> util = new ExcelUtil<TestOrder>(TestOrder.class);
        util.exportExcel(response, list, "订单测试数据");
    }

    /**
     * 获取订单测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testOrder:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testOrderService.selectTestOrderById(id));
    }

    /**
     * 新增订单测试
     */
    @PreAuthorize("@ss.hasPermi('test:testOrder:add')")
    @Log(title = "订单测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestOrder testOrder)
    {
        return toAjax(testOrderService.insertTestOrder(testOrder));
    }

    /**
     * 修改订单测试
     */
    @PreAuthorize("@ss.hasPermi('test:testOrder:edit')")
    @Log(title = "订单测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestOrder testOrder)
    {
        return toAjax(testOrderService.updateTestOrder(testOrder));
    }

    /**
     * 删除订单测试
     */
    @PreAuthorize("@ss.hasPermi('test:testOrder:remove')")
    @Log(title = "订单测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testOrderService.deleteTestOrderByIds(ids));
    }
}
