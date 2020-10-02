package org.myBlog.project.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.myBlog.project.entity.Blog;
import org.myBlog.project.enums.BlogStatusEnum;
import org.myBlog.project.mapper.BlogMapper;
import org.myBlog.project.service.BlogService;
import org.myBlog.project.util.GetUUID;
import org.myBlog.project.util.TimeOpt;
import org.myBlog.project.vo.bolg.request.AddBlogRequest;
import org.myBlog.project.vo.bolg.request.UpdateBlogRequest;
import org.myBlog.project.vo.bolg.response.BlogInfoResponse;
import org.myBlog.project.vo.bolg.response.BlogResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("BlogService")
@Slf4j
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;

//    private static final String BASE_PATH = "E:\\picture\\blog\\";
    private static final String BASE_PATH = "/home/wq/my-blog/picture/blog/";

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
                    .blogNo(blog.getBlogNo())
                    .blogCoverUrl(blog.getBlogCoverUrl())
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
    public BlogResponse queryBlogByBlogNo(String blogNo) {
        Blog blog = blogMapper.queryBlogByBlogNo(blogNo);
        BlogResponse response = BlogResponse.builder()
                .blogNo(blog.getBlogNo())
                .blogCoverUrl(blog.getBlogCoverUrl())
                .blogType(blog.getBlogType())
                .blogTagList(blog.getBlogTagList())
                .blogTitle(blog.getBlogTitle())
                .blogOverview(blog.getBlogOverview())
                .blogRawContent(blog.getBlogRawContent())
                .createTime(blog.getCreateTime())
                .build();
        return response;
    }

    /**
     * 查询在校经历与工作经历
     */
    @Override
    public List<BlogInfoResponse> querySpecialBlog() {
        List<BlogInfoResponse> responses = new ArrayList<>();
        List<Blog> specialBlogList = blogMapper.querySpecialBlog();
        for (Blog blog : specialBlogList) {
            BlogInfoResponse response = BlogInfoResponse.builder()
                    .blogNo(blog.getBlogNo())
                    .blogCoverUrl(blog.getBlogCoverUrl())
                    .blogType(blog.getBlogType())
                    .blogTagList(blog.getBlogTagList())
                    .blogTitle(blog.getBlogTitle())
                    .blogOverview(blog.getBlogOverview())
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
        String blogNo = "B" + GetUUID.getUUID();
        Date insertDate = new Date();
        Blog b = Blog.builder()
                .blogNo(blogNo)
                .blogCoverUrl(request.getBlogCoverUrl())
                .blogType(request.getBlogType())
                .blogTagList(request.getBlogTagList())
                .blogTitle(request.getBlogTitle())
                .blogOverview(request.getBlogOverview())
                .blogRawContent(request.getBlogRawContent())
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
    public void updateStatus(String blogNo, Integer status) {
        blogMapper.updateStatus(blogNo, status);
    }

    /**
     * 更新博客
     */
    @Override
    @Transactional
    public void updateBlog(UpdateBlogRequest request) {
        Blog b = Blog.builder()
                .blogNo(request.getBlogNo())
                .blogCoverUrl(request.getBlogCoverUrl())
                .blogTitle(request.getBlogTitle())
                .blogType(request.getBlogType())
                .blogTagList(request.getBlogTagList())
                .blogOverview(request.getBlogOverview())
                .blogRawContent(request.getBlogRawContent())
                .build();
        blogMapper.updateBlog(b);
    }

    @Override
    public void downloadMdFile(String blogNo, HttpServletResponse response) {
        OutputStream responseOutPut = null;
        try {
            Blog blog = blogMapper.queryBlogByBlogNo(blogNo);
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

    @Override
    public JSONObject uploadImg(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = fileName.split("\\.")[1];
        log.info("fileName: {}", file.getOriginalFilename());
        String imgName = GetUUID.getUUID(); // 随机的uuid
        String Date = TimeOpt.getCurrentTimeStr();
        String filePath = BASE_PATH + Date + "/" + imgName + "." + fileType;
        File imgFile = new File(filePath);
        if (!imgFile.exists()) {
            imgFile.mkdirs();
        }
        file.transferTo(imgFile);
        String imgUrl = "http://47.107.64.157/blog/" + Date + "/" + imgName + "." + fileType;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgUrl", imgUrl);
        return jsonObject;
    }
}
