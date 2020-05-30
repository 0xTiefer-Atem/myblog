package org.myBlog.project.controller;

import com.alibaba.fastjson.JSON;
import org.myBlog.project.dao.BlogDao;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.entity.BlogTag;
import org.myBlog.project.util.ResponseHelper;
import org.myBlog.project.util.ResponseV2;
import org.myBlog.project.util.StatusAndMsg;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文章表(Blog)表控制层
 *
 * @since 2020-05-19 16:04:02
 */
@RestController
@RequestMapping("/api/blog")
@CrossOrigin
public class BlogController {
    /**
     * 服务对象
     */
    @Resource
    private BlogDao blogDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public ResponseV2 selectOne(String id,String status) {
        System.out.println(id+"  "+status);
        Blog blog;
        try {
            blog = this.blogDao.queryById(id,status);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS, StatusAndMsg.ERROR1_MSG);
        }

        List<BlogTag> blogTagListJson = JSON.parseArray(blog.getBlogTagList(), BlogTag.class);
        blog.setBlogTagListJson(blogTagListJson);

        return ResponseHelper.create(blog, StatusAndMsg.SUCCESS1_STATUS, StatusAndMsg.SUCCESS1_MSG);
    }


    @GetMapping("/selectAll")
    public ResponseV2 selectAll() {
        List<Blog> blogList;
        try {
            blogList = this.blogDao.selectAll();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS,StatusAndMsg.ERROR1_MSG);
        }

        int length = blogList.size();
        for (int i = 0; i < length; i++) {
            List<BlogTag> blogTagListJson = JSON.parseArray(blogList.get(i).getBlogTagList(),BlogTag.class);
            blogList.get(i).setBlogTagListJson(blogTagListJson);
        }

        return ResponseHelper.create(blogList,StatusAndMsg.SUCCESS1_STATUS,StatusAndMsg.SUCCESS1_MSG);
    }



    @GetMapping("/selectAllByLimit")
    public ResponseV2 selectAllByLimit(int offset, int limit) {
        List<Blog> blogList;
        try {
            blogList = this.blogDao.selectAllByLimit(offset,limit);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS,StatusAndMsg.ERROR1_MSG);
        }

        int length = blogList.size();
        for (int i = 0; i < length; i++) {
            List<BlogTag> blogTagListJson = JSON.parseArray(blogList.get(i).getBlogTagList(),BlogTag.class);
            blogList.get(i).setBlogTagListJson(blogTagListJson);
        }

        return ResponseHelper.create(blogList,StatusAndMsg.SUCCESS1_STATUS,StatusAndMsg.SUCCESS1_MSG);
    }


    @GetMapping("/selectSpecialArticle")
    public ResponseV2 selectSpecialArticle() {
        List<Blog> blogList;
        try {
            blogList = this.blogDao.selectSpecialArticle();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS,StatusAndMsg.ERROR1_MSG);
        }

        return ResponseHelper.create(blogList,StatusAndMsg.SUCCESS1_STATUS,StatusAndMsg.SUCCESS1_MSG);
    }

}