package org.myBlog.project.vo.bolg.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author WangQian
 * @Date 2020/9/28 下午 10:34
 */

/**
 * 每篇博客基本信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogInfoResponse {
    /**
     * 博客No
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
     * 创建时间
     */
    private Date createTime;
}
