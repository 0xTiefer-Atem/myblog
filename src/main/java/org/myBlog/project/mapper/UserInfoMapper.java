package org.myBlog.project.mapper;

import org.apache.ibatis.annotations.*;
import org.myBlog.project.entity.UserInfo;

/**
 * 个人信息(UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 10:42:46
 */
@Mapper
public interface UserInfoMapper {

    UserInfo queryUserInfoByUserNo(@Param("userNo") String userNo);

}