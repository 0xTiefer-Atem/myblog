package org.myBlog.project.vo.bolg.response;

/**
 * @Author WangQian
 * @Date 2020/9/28 下午 11:36
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 每篇博客所有信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogResponse {
    /**
     * 博客编号
     */
    private String blogNo;
    /**
     * 分类
     */
    private String blogType;
    /**
     * 相关标签
     */
    private String blogTagList;
    /**
     * 标题
     */
    private String blogTitle;
    /**
     * 概览
     */
    private String blogOverview;
    /**
     * markdown原代码
     */
    private String blogRawContent;
    /**
     * 创建时间
     */
    private Date createTime;
}
