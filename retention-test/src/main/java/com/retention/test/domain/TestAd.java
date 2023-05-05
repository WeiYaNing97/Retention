package com.retention.test.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.retention.common.annotation.Excel;
import com.retention.common.core.domain.BaseEntity;

/**
 * 广告测试对象 test_ad
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public class TestAd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 广告ID */
    private Long id;

    /** 广告名称 */
    @Excel(name = "广告名称")
    private String name;

    /** 图片链接 */
    @Excel(name = "图片链接")
    private String imageUrl;

    /** 跳转链接 */
    @Excel(name = "跳转链接")
    private String linkUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setLinkUrl(String linkUrl) 
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() 
    {
        return linkUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("imageUrl", getImageUrl())
            .append("linkUrl", getLinkUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
