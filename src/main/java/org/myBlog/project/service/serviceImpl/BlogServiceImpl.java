package org.myBlog.project.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.enums.BlogStatusEnum;
import org.myBlog.project.mapper.BlogMapper;
import org.myBlog.project.service.BlogService;
import org.myBlog.project.util.GetUUID;
import org.myBlog.project.vo.bolg.request.AddBlogRequest;
import org.myBlog.project.vo.bolg.request.UpdateBlogRequest;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;

    /**
     * 返回博客信息列表
     */
    @Override
    public PageInfo<BlogInfoResponse> queryBlogList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfoResponse> blogInfoList = new ArrayList<>();
        List<Blog> blogs = blogMapper.queryBlogList();
        for (Blog blog : blogs) {
            BlogInfoResponse blogInfo = BlogInfoResponse.builder()
                    .blogId(blog.getBlogId())
                    .blogType(blog.getBlogType())
                    .blogTagList(blog.getBlogTagList())
                    .blogTitle(blog.getBlogTitle())
                    .blogOverview(blog.getBlogOverview())
                    .createTime(blog.getCreateTime())
                    .build();
            blogInfoList.add(blogInfo);
        }
        PageInfo<BlogInfoResponse> responsePageInfo = new PageInfo<>(blogInfoList);
        return responsePageInfo;
    }

    /**
     * 根据blogId查询博客
     */
    @Override
    public BlogResponse queryBlogByBlogId(String blogId) {
        Blog blog = blogMapper.queryBlogByBlogId(blogId);
        BlogResponse response = BlogResponse.builder()
                .blogId(blog.getBlogId())
                .blogType(blog.getBlogType())
                .blogTagList(blog.getBlogTagList())
                .blogTitle(blog.getBlogTitle())
                .blogOverview(blog.getBlogOverview())
                .blogRawContent(blog.getBlogRawContent())
                .blogContent(blog.getBlogContent())
                .createTime(blog.getCreateTime())
                .build();
        return response;
    }

    /**
     * 查询在校经历与工作经历
     */
    @Override
    public List<BlogResponse> querySpecialBlog() {
        List<BlogResponse> responses = new ArrayList<>();
        List<Blog> specialBlogList = blogMapper.querySpecialBlog();
        for (Blog blog : specialBlogList) {
            BlogResponse response = BlogResponse.builder()
                    .blogId(blog.getBlogId())
                    .blogType(blog.getBlogType())
                    .blogTagList(blog.getBlogTagList())
                    .blogTitle(blog.getBlogTitle())
                    .blogOverview(blog.getBlogOverview())
                    .blogContent(blog.getBlogContent())
                    .createTime(blog.getCreateTime())
                    .build();
            responses.add(response);
        }
        return responses;
    }

    /**
     * 新增博客
     */
    @Override
    @Transactional
    public void addBlog(AddBlogRequest request) {
        String blogId = "B" + GetUUID.getUUID();
        Date insertDate = new Date();
        Blog b = Blog.builder()
                .blogId(blogId)
                .blogType(request.getBlogType())
                .blogTagList(request.getBlogTagList())
                .blogTitle(request.getBlogTitle())
                .blogOverview(request.getBlogOverview())
                .blogRawContent(request.getBlogRawContent())
                .blogContent(request.getBlogContent())
                .blogStatus(BlogStatusEnum.USE.getStatus())
                .createTime(insertDate)
                .build();
        blogMapper.addBlog(b);
    }

    /**
     * 修改博客状态
     */
    @Override
    @Transactional
    public void updateStatus(String blogId, Integer status) {
        blogMapper.updateStatus(blogId, status);
    }

    /**
     * 更新博客
     */
    @Override
    @Transactional
    public void updateBlog(UpdateBlogRequest request) {
        Blog b = Blog.builder()
                .blogId(request.getBlogId())
                .blogTitle(request.getBlogTitle())
                .blogType(request.getBlogType())
                .blogTagList(request.getBlogTagList())
                .blogOverview(request.getBlogOverview())
                .blogRawContent(request.getBlogRawContent())
                .blogContent(request.getBlogContent())
                .build();
        blogMapper.updateBlog(b);
    }

    @Override
    public void downloadMdFile(String blogId, HttpServletResponse response) {
        OutputStream responseOutPut = null;
        try {
            Blog blog = blogMapper.queryBlogByBlogId(blogId);
            String blogTitle = blog.getBlogTitle();
            String fileName = URLEncoder.encode(blogTitle + ".md", "utf-8").replaceAll("\\+", "%20");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            responseOutPut = response.getOutputStream();
            responseOutPut.write(blog.getBlogRawContent().getBytes());
            responseOutPut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (responseOutPut != null) {
                try {
                    responseOutPut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
