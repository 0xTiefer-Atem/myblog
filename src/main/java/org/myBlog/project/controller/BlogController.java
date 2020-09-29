package org.myBlog.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.enums.ResultCodeEnum;
import org.myBlog.project.service.BlogService;
import org.myBlog.project.util.*;
import org.myBlog.project.vo.bolg.request.AddBlogRequest;
import org.myBlog.project.vo.bolg.request.UpdateBlogRequest;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
            return ResponseHelper.create(ResultCodeEnum.SELECT_ERROR.getCode(), ResultCodeEnum.SELECT_ERROR.getMsg());
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
            return ResponseHelper.create(ResultCodeEnum.UPDATE_ERROR.getCode(), ResultCodeEnum.UPDATE_ERROR.getMsg());
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
            return ResponseHelper.create(ResultCodeEnum.SELECT_ERROR.getCode(), ResultCodeEnum.SELECT_ERROR.getMsg());
        }
    }

    @ApiOperation("新增博客")
    @PostMapping("/add/blog")
    public ResponseV2 insertNewBlog(@RequestBody AddBlogRequest request) {
        log.info("新增博客-REQ: {}", JSON.toJSONString(request));
        try {
            blogService.addBlog(request);
            return ResponseHelper.create();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.INSERT_ERROR.getCode(), ResultCodeEnum.INSERT_ERROR.getMsg());
        }
    }


    @ApiOperation("更新博客状态")
    @GetMapping("/update/status")
    public ResponseV2 updateOneBlogStatus(@RequestParam("blogId") String blogId, @RequestParam("status") Integer status) {
        log.info("更新博客状态-REQ: {}, {}", blogId, status);
        try {
            blogService.updateStatus(blogId, status);
            return ResponseHelper.create();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.UPDATE_ERROR.getCode(), ResultCodeEnum.UPDATE_ERROR.getMsg());
        }
    }


    @ApiOperation("更新博客内容")
    @PostMapping("/update/content")
    public ResponseV2 updateBlog(@RequestBody UpdateBlogRequest request) {
        log.info("更新博客内容-REQ: {}", JSON.toJSONString(request));
        try {
            blogService.updateBlog(request);
            return ResponseHelper.create();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.UPDATE_ERROR.getCode(), ResultCodeEnum.UPDATE_ERROR.getMsg());
        }
    }
}