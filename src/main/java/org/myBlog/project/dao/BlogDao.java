package org.myBlog.project.dao;

import org.apache.ibatis.annotations.*;
import org.myBlog.project.entity.Blog;

import java.util.List;

/**
 * 文章表(Blog)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-19 16:04:00
 */


public interface BlogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    @Select("select * from blog where blog_id = #{id} and blog_status = #{status}")
    @Results(id = "blogMap",value = {
            @Result(property = "blogId", column = "blog_id"),
            @Result(property = "blogType", column = "blog_type"),
            @Result(property = "blogTagList",column = "blog_tag_list"),
            @Result(property = "blogOverview",column = "blog_overview"),
            @Result(property = "blogTitle",column = "blog_title"),
            @Result(property = "blogStatus",column = "blog_status"),
            @Result(property = "blogContent",column = "blog_content"),
            @Result(property = "createTime",column = "create_time")
    })
    Blog queryById(String id, String status);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */

    @Select("select blog_id, blog_type, blog_status, blog_tag_list, blog_overview, blog_title, create_time  from blog where blog_status = 1 limit #{offset}, #{limit}")
    @ResultMap("blogMap")
    List<Blog> selectAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    @Select("select blog_id, blog_type,  blog_status,   blog_tag_list, blog_overview, blog_title, create_time from blog where blog_status = 2")
    @ResultMap("blogMap")
    List<Blog> selectSpecialBlog();

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */

    @Select("select blog_id, blog_type, blog_status, blog_tag_list, blog_overview, blog_title, create_time  from blog where blog_status = 1 limit #{offset}, #{limit}")
    @ResultMap("blogMap")
    List<Blog> selectAll(@Param("offset") int offset, @Param("limit") int limit);


    @Insert("insert into blog (blog_id, blog_type, blog_tag_list, blog_overview, blog_title, blog_status, blog_content, create_time) values(#{blogId}, #{blogType}, #{blogTagList}, #{blogOverview}, #{blogTitle}, 1, #{blogContent}, #{createTime})")
    int insertNewBlog(Blog blog);


    @Update("update blog set blog_status = -1 where blog_id = #{id}")
    int updateOneBlogStatus(String id);


    @Update("update blog set blog_type = #{blogType}, blog_tag_list = #{blogTagList}, blog_overview = #{blogOverview}, blog_title = #{blogTitle}, blog_content = #{blogContent}, create_time = #{createTime} where blog_id = #{blogId}")
    int updateBlog(Blog blog);

}