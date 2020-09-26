package org.myblog.project.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import org.myblog.project.vo.bolg.response.RelatedLinks;
import org.myblog.project.vo.bolg.response.SkillInfo;
import org.myblog.project.entity.UserInfo;
import org.myblog.project.util.ResponseHelper;
import org.myblog.project.util.ResponseV2;
import org.myblog.project.util.ResultCode;
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