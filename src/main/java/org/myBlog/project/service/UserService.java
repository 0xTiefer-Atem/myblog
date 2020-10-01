package org.myBlog.project.service;

import com.alibaba.fastjson.JSONObject;
import org.myBlog.project.vo.user.request.UpdateUserInfoRequest;
import org.myBlog.project.vo.user.response.UserInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 4:24
 */
@Service
public interface UserService {
    /**
     * 查询用户信息
     */
    UserInfoResponse queryUserInfoByUserNo(String userNo);

    /**
     * 更新用户信息
     */
    void updateUserInfo(UpdateUserInfoRequest request);

    /**
     * 上传头像
     */
    JSONObject uploadAvatar(MultipartFile file);
}
