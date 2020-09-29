package org.myBlog.project.vo.bolg.request;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 2:19
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 添加博客请求
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddBlogRequest {
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
     * 内容
     */
    private String blogContent;
}
