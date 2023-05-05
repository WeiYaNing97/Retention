package com.retention.test.mapper;

import java.util.List;
import com.retention.test.domain.TestAd;

/**
 * 广告测试Mapper接口
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public interface TestAdMapper 
{
    /**
     * 查询广告测试
     * 
     * @param id 广告测试主键
     * @return 广告测试
     */
    public TestAd selectTestAdById(Long id);

    /**
     * 查询广告测试列表
     * 
     * @param testAd 广告测试
     * @return 广告测试集合
     */
    public List<TestAd> selectTestAdList(TestAd testAd);

    /**
     * 新增广告测试
     * 
     * @param testAd 广告测试
     * @return 结果
     */
    public int insertTestAd(TestAd testAd);

    /**
     * 修改广告测试
     * 
     * @param testAd 广告测试
     * @return 结果
     */
    public int updateTestAd(TestAd testAd);

    /**
     * 删除广告测试
     * 
     * @param id 广告测试主键
     * @return 结果
     */
    public int deleteTestAdById(Long id);

    /**
     * 批量删除广告测试
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestAdByIds(Long[] ids);
}
