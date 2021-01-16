package org.myBlog.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;

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

    List<BlogInfoResponse> queryBlogInfoList();

    Blog queryBlogByBlogNo(@Param("blogNo") String blogNo);

    List<Blog> querySpecialBlog();

    void addBlog(Blog blog);

    void updateStatus(@Param("blogNo") String blogNo, @Param("status") Integer status);

    void updateBlog(Blog blog);

    List<BlogInfoResponse> queryList(@Param("queryKey") String queryKey);

    List<String> queryBolgTypes();
}