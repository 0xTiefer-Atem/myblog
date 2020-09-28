package org.myBlog.project.service.serviceImpl;

import org.myBlog.project.entity.Blog;
import org.myBlog.project.service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Override
    public List<Blog> queryBlogList(Integer pageNum, Integer pageSize) {
        return null;
    }
}
