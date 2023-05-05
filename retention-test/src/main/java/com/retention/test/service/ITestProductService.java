package com.retention.test.service;

import java.util.List;
import com.retention.test.domain.TestProduct;

/**
 * 商品测试Service接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface ITestProductService 
{
    /**
     * 查询商品测试
     * 
     * @param id 商品测试主键
     * @return 商品测试
     */
    public TestProduct selectTestProductById(Long id);

    /**
     * 查询商品测试列表
     * 
     * @param testProduct 商品测试
     * @return 商品测试集合
     */
    public List<TestProduct> selectTestProductList(TestProduct testProduct);

    /**
     * 新增商品测试
     * 
     * @param testProduct 商品测试
     * @return 结果
     */
    public int insertTestProduct(TestProduct testProduct);

    /**
     * 修改商品测试
     * 
     * @param testProduct 商品测试
     * @return 结果
     */
    public int updateTestProduct(TestProduct testProduct);

    /**
     * 批量删除商品测试
     * 
     * @param ids 需要删除的商品测试主键集合
     * @return 结果
     */
    public int deleteTestProductByIds(Long[] ids);

    /**
     * 删除商品测试信息
     * 
     * @param id 商品测试主键
     * @return 结果
     */
    public int deleteTestProductById(Long id);
}
