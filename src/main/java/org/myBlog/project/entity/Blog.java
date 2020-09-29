package org.myBlog.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 文章表(Blog)实体类
 *
 * @author makejava
 * @since 2020-05-19 16:03:59
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {

    private Integer id;
    /**
     * 文章id
     */
    private String blogId;
    /**
     * 文章分类
     */
    private String blogType;
    /**
     * 文章标签
     */
    private String blogTagList;

    /**
     * 文章标题
     */
    private String blogTitle;

    /**
     * 概览
     */
    private String blogOverview;
    /**
     * 文章内容
     */
    private String blogContent;

    /**
     * 文章使用状态
     */
    private int blogStatus;
    /**
     * 文章创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}