package com.retention.test.service.impl;

import java.util.List;
import com.retention.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retention.test.mapper.TestProductMapper;
import com.retention.test.domain.TestProduct;
import com.retention.test.service.ITestProductService;

/**
 * 商品测试Service业务层处理
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
@Service
public class TestProductServiceImpl implements ITestProductService 
{
    @Autowired
    private TestProductMapper testProductMapper;

    /**
     * 查询商品测试
     * 
     * @param id 商品测试主键
     * @return 商品测试
     */
    @Override
    public TestProduct selectTestProductById(Long id)
    {
        return testProductMapper.selectTestProductById(id);
    }

    /**
     * 查询商品测试列表
     * 
     * @param testProduct 商品测试
     * @return 商品测试
     */
    @Override
    public List<TestProduct> selectTestProductList(TestProduct testProduct)
    {
        return testProductMapper.selectTestProductList(testProduct);
    }

    /**
     * 新增商品测试
     * 
     * @param testProduct 商品测试
     * @return 结果
     */
    @Override
    public int insertTestProduct(TestProduct testProduct)
    {
        testProduct.setCreateTime(DateUtils.getNowDate());
        return testProductMapper.insertTestProduct(testProduct);
    }

    /**
     * 修改商品测试
     * 
     * @param testProduct 商品测试
     * @return 结果
     */
    @Override
    public int updateTestProduct(TestProduct testProduct)
    {
        testProduct.setUpdateTime(DateUtils.getNowDate());
        return testProductMapper.updateTestProduct(testProduct);
    }

    /**
     * 批量删除商品测试
     * 
     * @param ids 需要删除的商品测试主键
     * @return 结果
     */
    @Override
    public int deleteTestProductByIds(Long[] ids)
    {
        return testProductMapper.deleteTestProductByIds(ids);
    }

    /**
     * 删除商品测试信息
     * 
     * @param id 商品测试主键
     * @return 结果
     */
    @Override
    public int deleteTestProductById(Long id)
    {
        return testProductMapper.deleteTestProductById(id);
    }
}
