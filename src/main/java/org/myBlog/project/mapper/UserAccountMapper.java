package org.myBlog.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.myBlog.project.entity.UserAccount;

@Mapper
public interface UserAccountMapper {
    int insert(UserAccount record);

    int insertSelective(UserAccount record);
}