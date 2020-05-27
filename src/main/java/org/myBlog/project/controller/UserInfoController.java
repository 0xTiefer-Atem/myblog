package org.myBlog.project.controller;

import org.myBlog.project.dao.UserInfoDao;
import org.myBlog.project.entity.UserInfo;
import org.myBlog.project.util.ResponseHelper;
import org.myBlog.project.util.ResponseV2;
import org.myBlog.project.util.StatusAndMsg;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 个人信息(UserInfo)表控制层
 *
 * @author makejava
 * @since 2020-05-27 10:45:19
 */
@RestController
@RequestMapping("/api/blog")
public class UserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserInfoDao userInfoDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectUserInfo")
    public ResponseV2 selectOne(Integer id) {
        UserInfo userInfo;
        try{
            userInfo = userInfoDao.queryById(1);
        }catch (Exception e) {
            return ResponseHelper.create(StatusAndMsg.ERROR1_STATUS,StatusAndMsg.ERROR1_MSG);
        }
        return ResponseHelper.create(userInfo,StatusAndMsg.SUCCESS1_STATUS,StatusAndMsg.SUCCESS1_MSG);
    }

}