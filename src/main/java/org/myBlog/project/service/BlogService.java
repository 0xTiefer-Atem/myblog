package org.myBlog.project.service;

import com.github.pagehelper.PageInfo;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客操作业务层
 */
@Service
public interface BlogService {

    /**
     * 查询博客列表
     */
    PageInfo<BlogInfoResponse> queryBlogList(Integer pageNum, Integer pageSize);

    /**
     * 根据blogId查询博客
     */
    BlogResponse queryBlogByBlogId(String blogId);

    /**
     * 查询在校经历与工作经历
     */
    List<BlogResponse> querySpecialBlog();
}
