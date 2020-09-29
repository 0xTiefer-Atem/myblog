package org.myBlog.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.service.BlogService;
import org.myBlog.project.util.*;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/blog")
@CrossOrigin
@Slf4j
public class BlogController {

    @Resource
    private BlogService blogService;


    @ApiOperation("博客信息列表")
    @GetMapping("/list")
    public ResponseV2 selectAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        log.info("博客信息列表-REQ: {},{}", pageNum, pageSize);
        try {
            PageInfo<BlogInfoResponse> responsePageInfo = blogService.queryBlogList(pageNum, pageSize);
            log.info("博客信息列表-RESP: {}", JSON.toJSONString(responsePageInfo));
            return ResponseHelper.create(responsePageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.SELECT_ERROR.getCode(), ResultCode.SELECT_ERROR.getMsg());
        }
    }

    @ApiOperation("一篇博客信息")
    @GetMapping("/query/one")
    public ResponseV2 selectOneBlog(@RequestParam("blogId") String blogId) {
        log.info("一篇博客信息-REQ: {}", blogId);
        try {
            BlogResponse response = blogService.queryBlogByBlogId(blogId);
            log.info("一篇博客信息-RESP: {}", JSON.toJSONString(response));
            return ResponseHelper.create(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.SELECT_ERROR.getCode(), ResultCode.SELECT_ERROR.getMsg());
        }
    }

    @ApiOperation("个人简历和在校经历")
    @GetMapping("/query/special")
    public ResponseV2 querySpecialBlog() {
        try {
            List<BlogResponse> responses = blogService.querySpecialBlog();
            log.info("个人简历和在校经历-RESP: {}", JSON.toJSONString(responses));
            return ResponseHelper.create(responses);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.SELECT_ERROR.getCode(), ResultCode.SELECT_ERROR.getMsg());
        }


    }

    @ApiOperation("新增博客")
    @PostMapping("/add/blog")
    public ResponseV2 insertNewBlog(@RequestBody Blog blog) {
        Date createTime = TimeOpt.getCurrentTime();
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

        return ResponseHelper.create();
    }


    @ApiOperation("更新博客状态")
    @PostMapping("/update/status")
    public ResponseV2 updateOneBlogStatus(@RequestBody JSONObject data) {
        String id = data.getString("id");
        System.out.println(id);
        try {
//            blogDao.updateOneBlogStatus(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCode.UPDATE_ERROR.getCode(), ResultCode.UPDATE_ERROR.getMsg());
        }
        return ResponseHelper.create();
    }


    @ApiOperation("更新博客内容")
    @PostMapping("/update/content")
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

        return ResponseHelper.create();
    }
}