package org.myblog.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.myblog.project.entity.Blog;
import org.myblog.project.service.BlogService;
import org.myblog.project.util.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/blog")
@CrossOrigin
@Slf4j
public class BlogController {

    @Resource
    private BlogService blogService;


    @ApiOperation("一篇博客信息")
    @GetMapping("/query/one")
    public ResponseV2 selectOneBlog(String id, String status) {
        log.info("id = {}, status = {}", id, status);
        return ResponseHelper.create(ResultCode.OPT_SUCCESS.getCode(), ResultCode.OPT_SUCCESS.getMsg());
    }


    @ApiOperation("博客列表")
    @GetMapping("/blog/list")
    public ResponseV2 selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>();
        return ResponseHelper.create(ResultCode.OPT_SUCCESS.getCode(), ResultCode.OPT_SUCCESS.getMsg());
    }


    @ApiOperation("个人简历和在校经历")
    @GetMapping("/select/special")
    public ResponseV2 selectSpecialBlog() {
        List<Blog> blogList;
        try {
            blogList = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.SELECT_ERROR.getCode(), ResultCode.SELECT_ERROR.getMsg());
        }

        return ResponseHelper.create(ResultCode.OPT_SUCCESS.getCode(), ResultCode.OPT_SUCCESS.getMsg());
    }

    @ApiOperation("新增博客")
    @PostMapping("/insert/blog")
    public ResponseV2 insertNewBlog(@RequestBody Blog blog) {
        String createTime = TimeOpt.getCurrentTime();
        String blogId = GetUUID.getUUID();
        blog.setBlogId(blogId);
        blog.setCreateTime(createTime);
        System.out.println(blog);

        try {
//            blogDao.insertNewBlog(blog);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.INSERT_ERROR.getCode(), ResultCode.INSERT_ERROR.getMsg());
        }

        return ResponseHelper.create(ResultCode.OPT_SUCCESS.getCode(), ResultCode.OPT_SUCCESS.getMsg());
    }


    @ApiOperation("更新博客状态")
    @PostMapping("/update/blog/status")
    public ResponseV2 updateOneBlogStatus(@RequestBody JSONObject data) {
        String id = data.getString("id");
        System.out.println(id);
        try {
//            blogDao.updateOneBlogStatus(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.UPDATE_ERROR.getCode(), ResultCode.UPDATE_ERROR.getMsg());
        }
        return ResponseHelper.create(ResultCode.OPT_SUCCESS.getCode(), ResultCode.OPT_SUCCESS.getMsg());
    }


    @ApiOperation("更新博客内容")
    @PostMapping("/update/blog")
    public ResponseV2 updateBlog(@RequestBody JSONObject data) {
        Blog blog = new Blog();
        blog.setBlogId(data.getString("blogId"));
        blog.setBlogType(data.getString("blogType"));
        blog.setBlogTagList(data.getString("blogTagList"));
        blog.setBlogOverview(data.getString("blogOverview"));
        blog.setBlogTitle(data.getString("blogTitle"));
        blog.setBlogContent(data.getString("blogContent"));
        blog.setCreateTime(TimeOpt.getCurrentTime());

        try {
//            blogDao.updateBlog(blog);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.UPDATE_ERROR.getCode(), ResultCode.UPDATE_ERROR.getMsg());
        }

        return ResponseHelper.create(ResultCode.OPT_SUCCESS.getCode(), ResultCode.OPT_SUCCESS.getMsg());
    }
}