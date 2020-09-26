package org.myblog.project.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.myblog.project.entity.UserInfo;

import java.util.List;

/**
 * 个人信息(UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 10:42:46
 */
public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

}