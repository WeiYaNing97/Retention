package com.retention.test.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.retention.common.annotation.Excel;
import com.retention.common.core.domain.BaseEntity;

/**
 * 日志测试对象 test_log
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public class TestLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志ID */
    private Long id;

    /** 日志级别 */
    @Excel(name = "日志级别")
    private String level;

    /** 日志内容 */
    @Excel(name = "日志内容")
    private String message;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("level", getLevel())
            .append("message", getMessage())
            .append("createTime", getCreateTime())
            .toString();
    }
}
