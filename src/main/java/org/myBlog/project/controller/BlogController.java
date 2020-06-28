package org.myBlog.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.myBlog.project.dao.BlogDao;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.entity.BlogTag;
import org.myBlog.project.util.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/selectOneBlog")
    public ResponseV2 selectOneBlog(String id,String status) {
        System.out.println(id+"  "+status);
        Blog blog;
        try {
            blog = this.blogDao.queryById(id,status);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS, StatusAndMsg.ERROR1_MSG);
        }

        return ResponseHelper.create(blog, StatusAndMsg.SUCCESS1_STATUS, StatusAndMsg.SUCCESS1_MSG);
    }


    @GetMapping("/selectAll")
    public ResponseV2 selectAll(int offset, int limit) {
        List<Blog> blogList;
        try {
            blogList = this.blogDao.selectAll(offset, limit);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS,StatusAndMsg.ERROR1_MSG);
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

        return ResponseHelper.create(blogList,StatusAndMsg.SUCCESS1_STATUS,StatusAndMsg.SUCCESS1_MSG);
    }


    @GetMapping("/selectSpecialBlog")
    public ResponseV2 selectSpecialBlog() {
        List<Blog> blogList;
        try {
            blogList = this.blogDao.selectSpecialBlog();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS,StatusAndMsg.ERROR1_MSG);
        }

        return ResponseHelper.create(blogList,StatusAndMsg.SUCCESS1_STATUS,StatusAndMsg.SUCCESS1_MSG);
    }

    @PostMapping("/insertNewBlog")
    public ResponseV2 insertNewBlog(@RequestBody  Blog blog) {
        String createTime = TimeOpt.getCurrentTime();
        String blogId = GetUUID.getUUID();
        blog.setBlogId(blogId);
        blog.setCreateTime(createTime);
        System.out.println(blog);

        try{
            blogDao.insertNewBlog(blog);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR2_STATUS,StatusAndMsg.ERROR2_MSG);
        }

        return ResponseHelper.create(StatusAndMsg.SUCCESS2_STATUS,StatusAndMsg.SUCCESS2_MSG);
    }


    @PostMapping("/updateOneBlogStatus")
    public ResponseV2 updateOneBlogStatus(@RequestBody JSONObject data) {
        String id = data.getString("id");
        System.out.println(id);
        try {
            blogDao.updateOneBlogStatus(id);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR3_STATUS,StatusAndMsg.ERROR3_MSG);
        }
        return ResponseHelper.create(StatusAndMsg.SUCCESS3_STATUS,StatusAndMsg.SUCCESS3_MSG);
    }


    @PostMapping("/updateBlog")
    public ResponseV2 updateBlog(@RequestBody JSONObject data) {
        Blog blog = new Blog();
        blog.setBlogId(data.getString("blogId"));
        blog.setBlogType(data.getString("blogType"));
        blog.setBlogTagList(data.getString("blogTagList"));
        blog.setBlogOverview(data.getString("blogOverview"));
        blog.setBlogTitle(data.getString("blogTitle"));
        blog.setBlogContent(data.getString("blogContent"));
        blog.setCreateTime(TimeOpt.getCurrentTime());

        try{
            blogDao.updateBlog(blog);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseHelper.create(StatusAndMsg.ERROR4_STATUS,StatusAndMsg.ERROR4_MSG);
        }

        return ResponseHelper.create(StatusAndMsg.SUCCESS4_STATUS,StatusAndMsg.SUCCESS4_MSG);
    }
}