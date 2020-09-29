package org.myBlog.project.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.mapper.BlogMapper;
import org.myBlog.project.service.BlogService;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;

    /**
     * 返回博客信息列表
     * */
    @Override
    public PageInfo<BlogInfoResponse> queryBlogList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BlogInfoResponse> blogInfoList = new ArrayList<>();
        List<Blog> blogs  = blogMapper.queryBlogList();
        for (Blog blog: blogs) {
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
        PageInfo<BlogInfoResponse>  responsePageInfo = new PageInfo<>(blogInfoList);
        return responsePageInfo;
    }

    @Override
    public BlogResponse queryBlogByBlogId(String blogId) {
        Blog blog = blogMapper.queryBlogByBlogId(blogId);
        BlogResponse response = BlogResponse.builder()
                .blogId(blog.getBlogId())
                .blogType(blog.getBlogType())
                .blogTagList(blog.getBlogTagList())
                .blogTitle(blog.getBlogTitle())
                .blogOverview(blog.getBlogOverview())
                .blogContent(blog.getBlogContent())
                .createTime(blog.getCreateTime())
                .build();
        return response;
    }

    @Override
    public List<BlogResponse> querySpecialBlog() {
        List<BlogResponse> responses = new ArrayList<>();
        List<Blog> specialBlogList = blogMapper.querySpecialBlog();
        for (Blog blog: specialBlogList) {
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
}
