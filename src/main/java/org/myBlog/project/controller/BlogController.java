package org.myBlog.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.myBlog.project.enums.ResultCodeEnum;
import org.myBlog.project.service.BlogService;
import org.myBlog.project.util.*;
import org.myBlog.project.vo.bolg.request.AddBlogRequest;
import org.myBlog.project.vo.bolg.request.UpdateBlogRequest;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseV2 selectOneBlog(@RequestParam("blogNo") String blogNo) {
        log.info("一篇博客信息-REQ: {}", blogNo);
        try {
            BlogResponse response = blogService.queryBlogByBlogNo(blogNo);
            log.info("一篇博客信息-RESP: {}", JSON.toJSONString(response));
            return ResponseHelper.create(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.SELECT_ERROR.getCode(), ResultCodeEnum.SELECT_ERROR.getMsg());
        }
    }

    @ApiOperation("个人简历和在校经历")
    @GetMapping("/query/special")
    public ResponseV2 querySpecialBlog() {
        try {
            List<BlogInfoResponse> responses = blogService.querySpecialBlog();
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
    public ResponseV2 updateOneBlogStatus(@RequestParam("blogNo") String blogNo, @RequestParam("status") Integer status) {
        log.info("更新博客状态-REQ: {}, {}", blogNo, status);
        try {
            blogService.updateStatus(blogNo, status);
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

    @ApiOperation("md文件下载")
    @GetMapping("/download/md")
    public void downloadMdFile(@RequestParam("blogNo") String blogNo, HttpServletResponse response) {
        log.info("md文件下载: {}", blogNo);
        try {
            blogService.downloadMdFile(blogNo, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("上传图片")
    @PostMapping("/upload/img")
    public ResponseV2 uploadImg(@RequestParam("file") MultipartFile file) {
        log.info("上传图片-REQ: {}", file.getOriginalFilename());
        try {
            JSONObject res = blogService.uploadImg(file);
            log.info("上传图片-RESP: {}", JSON.toJSONString(res));
            return ResponseHelper.create(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.UPLOAD_ERROR.getCode(), ResultCodeEnum.UPLOAD_ERROR.getMsg());
        }
    }

    @ApiOperation("根据关键字查询文章")
    @GetMapping("/query/key")
    public ResponseV2 queryByKey(@RequestParam("queryKey") String queryKey, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        log.info("根据关键字查询文章-REQ: {}, {}, {}", queryKey, pageNum, pageSize);
        try {
            PageInfo<BlogInfoResponse> responsePageInfo = blogService.queryByKey(queryKey, pageNum, pageSize);
            log.info("根据关键字查询文章-RESP: {}", responsePageInfo);
            return ResponseHelper.create(responsePageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.SELECT_ERROR.getCode(), ResultCodeEnum.SELECT_ERROR.getMsg());
        }
    }

    @ApiOperation("查询博客类别")
    @GetMapping("/query/types")
    public ResponseV2 queryByKey() {
        try {
            List<String> blogTypes = blogService.queryBolgTypes();
            log.info("查询博客类别-RESP: {}", blogTypes);
            return ResponseHelper.create(blogTypes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.SELECT_ERROR.getCode(), ResultCodeEnum.SELECT_ERROR.getMsg());
        }
    }
}