package org.myblog.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.myblog.project.entity.UserAccount;

@Mapper
public interface UserAccountMapper {
    int insert(UserAccount record);

    int insertSelective(UserAccount record);
}