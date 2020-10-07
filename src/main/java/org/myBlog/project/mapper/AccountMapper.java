package org.myBlog.project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.myBlog.project.entity.Account;

@Mapper
public interface AccountMapper {
    Account queryAccount(@Param("userAccount") String userAccount);
}