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
import com.retention.test.domain.TestProduct;
import com.retention.test.service.ITestProductService;
import com.retention.common.utils.poi.ExcelUtil;
import com.retention.common.core.page.TableDataInfo;

/**
 * 商品测试Controller
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@RestController
@RequestMapping("/test/testProduct")
public class TestProductController extends BaseController
{
    @Autowired
    private ITestProductService testProductService;

    /**
     * 查询商品测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testProduct:list')")
    @GetMapping("/list")
    public TableDataInfo list(TestProduct testProduct)
    {
        startPage();
        List<TestProduct> list = testProductService.selectTestProductList(testProduct);
        return getDataTable(list);
    }

    /**
     * 导出商品测试列表
     */
    @PreAuthorize("@ss.hasPermi('test:testProduct:export')")
    @Log(title = "商品测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TestProduct testProduct)
    {
        List<TestProduct> list = testProductService.selectTestProductList(testProduct);
        ExcelUtil<TestProduct> util = new ExcelUtil<TestProduct>(TestProduct.class);
        util.exportExcel(response, list, "商品测试数据");
    }

    /**
     * 获取商品测试详细信息
     */
    @PreAuthorize("@ss.hasPermi('test:testProduct:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(testProductService.selectTestProductById(id));
    }

    /**
     * 新增商品测试
     */
    @PreAuthorize("@ss.hasPermi('test:testProduct:add')")
    @Log(title = "商品测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TestProduct testProduct)
    {
        return toAjax(testProductService.insertTestProduct(testProduct));
    }

    /**
     * 修改商品测试
     */
    @PreAuthorize("@ss.hasPermi('test:testProduct:edit')")
    @Log(title = "商品测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TestProduct testProduct)
    {
        return toAjax(testProductService.updateTestProduct(testProduct));
    }

    /**
     * 删除商品测试
     */
    @PreAuthorize("@ss.hasPermi('test:testProduct:remove')")
    @Log(title = "商品测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(testProductService.deleteTestProductByIds(ids));
    }
}
