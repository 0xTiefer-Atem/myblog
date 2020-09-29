package org.myBlog.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.myBlog.project.entity.Blog;

import java.util.List;

/**
 * 文章表(Blog)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-19 16:04:00
 */

@Mapper
public interface BlogMapper {

    List<Blog> queryBlogList();

    Blog queryBlogByBlogId(@Param("blogId") String blogId);

    List<Blog> querySpecialBlog();
}