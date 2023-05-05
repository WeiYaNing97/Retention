package com.retention.test.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.retention.common.annotation.Excel;
import com.retention.common.core.domain.BaseEntity;

/**
 * 消息测试对象 test_message
 * 
 * @author 小宁子
 * @date 2023-04-15
 */
public class TestMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 消息ID */
    private Long id;

    /** 发送者ID */
    @Excel(name = "发送者ID")
    private Long senderId;

    /** 接收者ID */
    @Excel(name = "接收者ID")
    private Long receiverId;

    /** 消息内容 */
    @Excel(name = "消息内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSenderId(Long senderId) 
    {
        this.senderId = senderId;
    }

    public Long getSenderId() 
    {
        return senderId;
    }
    public void setReceiverId(Long receiverId) 
    {
        this.receiverId = receiverId;
    }

    public Long getReceiverId() 
    {
        return receiverId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("senderId", getSenderId())
            .append("receiverId", getReceiverId())
            .append("content", getContent())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
