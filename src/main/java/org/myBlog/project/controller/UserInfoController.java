package org.myBlog.project.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.myBlog.project.entity.UserInfo;
import org.myBlog.project.util.ResponseHelper;
import org.myBlog.project.util.ResponseV2;
import org.myBlog.project.util.ResultCode;
import org.myBlog.project.vo.bolg.response.RelatedLinks;
import org.myBlog.project.vo.bolg.response.SkillInfo;
import org.springframework.web.bind.annotation.*;

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
public class UserInfoController {

    @ApiOperation("查询用户信息")
    @GetMapping("/selectUserInfo")
    public ResponseV2 selectOne(Integer id) {
        UserInfo userInfo;
        try {
            userInfo = new UserInfo();
        } catch (Exception e) {
            return ResponseHelper.create(ResultCode.SELECT_ERROR.getCode(), ResultCode.SELECT_ERROR.getMsg());
        }

        List<RelatedLinks> relatedLinks = JSON.parseArray(userInfo.getUserRelatedLinks(), RelatedLinks.class);

        userInfo.setUserRelatedLinksJson(relatedLinks);

        List<SkillInfo> skillInfos = JSON.parseArray(userInfo.getUserSkillInfoList(), SkillInfo.class);

        userInfo.setUserSkillInfoListJson(skillInfos);

        return ResponseHelper.create(userInfo, ResultCode.SELECT_ERROR.getCode(), ResultCode.SELECT_ERROR.getMsg());
    }

}