package org.myBlog.project.service.serviceImpl;

import org.myBlog.project.entity.UserInfo;
import org.myBlog.project.mapper.UserInfoMapper;
import org.myBlog.project.service.UserService;
import org.myBlog.project.vo.user.response.UserInfoResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 4:24
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 根据用户编号查询用户信息
     * */
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
}
