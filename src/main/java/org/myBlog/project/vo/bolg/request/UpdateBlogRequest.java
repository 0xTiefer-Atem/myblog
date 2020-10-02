package org.myBlog.project.vo.bolg.request;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 3:40
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 更新博客请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBlogRequest {
    /**
     * 博客编号
     */
    private String blogNo;
    /**
     * 封面URL
     */
    private String blogCoverUrl;
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
}
