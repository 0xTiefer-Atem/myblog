package org.myblog.project.service;

import org.myblog.project.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客操作业务层
 * */
@Service
public interface BlogService {

    /**
     * 查询博客列表
     * */

    List<Blog> queryBlogList();
}
