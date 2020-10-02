package org.myBlog.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.myBlog.project.entity.UserInfo;
import org.myBlog.project.enums.ResultCodeEnum;
import org.myBlog.project.service.UserService;
import org.myBlog.project.util.ResponseHelper;
import org.myBlog.project.util.ResponseV2;
import org.myBlog.project.vo.bolg.response.RelatedLinks;
import org.myBlog.project.vo.bolg.response.SkillInfo;
import org.myBlog.project.vo.user.request.UpdateUserInfoRequest;
import org.myBlog.project.vo.user.response.UserInfoResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 个人信息(UserInfo)表控制层
 *
 * @author makejava
 * @since 2020-05-27 10:45:19
 */
@RestController
@RequestMapping("/api/blog")
@CrossOrigin
@Slf4j
public class UserInfoController {
    @Resource
    private UserService userService;

    @ApiOperation("查询用户信息")
    @GetMapping("/select/user/info")
    public ResponseV2 selectUserInfo(@RequestParam("userNo") String userNo) {
        log.info("查询用户信息-REQ: {}", userNo);
        try {
            UserInfoResponse response = userService.queryUserInfoByUserNo(userNo);
            log.info("查询用户信息-RESP: {}", JSON.toJSONString(response));
            return ResponseHelper.create(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.SELECT_ERROR.getCode(), ResultCodeEnum.SELECT_ERROR.getMsg());
        }
    }

    @ApiOperation("修改用户信息")
    @PostMapping("/update/user/info")
    public ResponseV2 updaeUserInfo(@RequestBody UpdateUserInfoRequest request) {
        log.info("修改用户信息-REQ: {}", JSON.toJSONString(request));
        try {
            userService.updateUserInfo(request);
            return ResponseHelper.create();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.UPDATE_ERROR.getCode(), ResultCodeEnum.UPDATE_ERROR.getMsg());
        }
    }

    @ApiOperation("头像上传")
    @PostMapping("/upload/avatar")
    public ResponseV2 uploadAvatar(@RequestParam("file") MultipartFile file) {
        log.info("头像上传-REQ: {}", JSON.toJSONString(file.getOriginalFilename()));
        try {
            JSONObject res = userService.uploadAvatar(file);
            log.info("头像上传-RESP: {}", JSON.toJSONString(res));
            return ResponseHelper.create(res);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseHelper.create(ResultCodeEnum.UPDATE_ERROR.getCode(), ResultCodeEnum.UPDATE_ERROR.getMsg());
        }
    }
}