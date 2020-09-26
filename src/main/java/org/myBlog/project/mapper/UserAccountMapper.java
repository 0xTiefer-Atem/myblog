package org.myblog.project.mapper;

import org.myblog.project.entity.UserAccount;

public interface UserAccountMapper {
    int insert(UserAccount record);

    int insertSelective(UserAccount record);
}