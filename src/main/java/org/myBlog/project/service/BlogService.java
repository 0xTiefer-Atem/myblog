package org.myBlog.project.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.vo.bolg.request.AddBlogRequest;
import org.myBlog.project.vo.bolg.request.UpdateBlogRequest;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 博客操作业务层
 */
@Service
public interface BlogService {

    /**
     * 查询博客列表
     */
    PageInfo<BlogInfoResponse> queryBlogList(Integer pageNum, Integer pageSize);

    /**
     * 根据blogId查询博客
     */
    BlogResponse queryBlogByBlogId(String blogId);

    /**
     * 查询在校经历与工作经历
     */
    List<BlogResponse> querySpecialBlog();

    /**
     * 新增博客
     */
    void addBlog(AddBlogRequest request);

    /**
     * 修改博客状态
     */
    void updateStatus(String blogId, Integer status);

    /**
     * 更新博客
     */
    void updateBlog(UpdateBlogRequest request);

    /**
     * 下载md文件
     */
    void downloadMdFile(String blogId, HttpServletResponse response);

    /**
     * md上传图片
     * */
    JSONObject uploadImg(MultipartFile file, String blogId) throws IOException;
}
