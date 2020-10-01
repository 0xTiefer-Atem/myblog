package org.myBlog.project.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.myBlog.project.entity.UserInfo;
import org.myBlog.project.mapper.UserInfoMapper;
import org.myBlog.project.service.UserService;
import org.myBlog.project.util.GetUUID;
import org.myBlog.project.vo.user.request.UpdateUserInfoRequest;
import org.myBlog.project.vo.user.response.UserInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 4:24
 */
@Slf4j
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userInfoMapper;

    private static String BASE_PATH = "/home/wq/my-blog/picture/user/avatar";

    /**
     * 根据用户编号查询用户信息
     */
    @Override
    public UserInfoResponse queryUserInfoByUserNo(String userNo) {
        UserInfo userInfo = userInfoMapper.queryUserInfoByUserNo(userNo);
        UserInfoResponse response = UserInfoResponse.builder()
                .userNo(userInfo.getUserNo())
                .userAvatar(userInfo.getUserAvatar())
                .userName(userInfo.getUserName())
                .userMotor(userInfo.getUserMotor())
                .userRelatedLinks(userInfo.getUserRelatedLinks())
                .userSkillInfoList(userInfo.getUserSkillInfoList())
                .build();
        return response;
    }

    /**
     * 更新用户信息
     */
    @Override
    @Transactional
    public void updateUserInfo(UpdateUserInfoRequest request) {
        UserInfo userInfo = UserInfo.builder()
                .userNo(request.getUserNo())
                .userAvatar(request.getUserAvatar())
                .userName(request.getUserName())
                .userMotor(request.getUserMotor())
                .userRelatedLinks(request.getUserRelatedLinks())
                .userSkillInfoList(request.getUserSkillInfoList())
                .build();
        userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public JSONObject uploadAvatar(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String fileType = fileName.split("\\.")[1];
        log.info("fileName: {}", file.getOriginalFilename());
        String name = GetUUID.getUUID(); // 随机的uuid
        String filePath = BASE_PATH + name + "." + fileType;
        try {
            File dest = new File(filePath);
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgUrl = "http://47.107.64.157/user/avatar/" + name + "." + fileType;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imgUrl", imgUrl);
        return jsonObject;
    }
}
