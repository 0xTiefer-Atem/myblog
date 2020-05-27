package org.myBlog.project.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.myBlog.project.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 个人信息(UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-27 10:42:46
 */
public interface UserInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Select("select * from user_info where user_id = #{userId}")
    @Results(id = "userInfoMap",value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userAvatar", column = "user_avatar"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userMotor",column = "user_motor"),
            @Result(property = "userRelatedLinks",column = "user_related_links"),
            @Result(property = "userSkillInfoList",column = "user_skillInfo_list"),
            @Result(property = "createTime",column = "create_time")
    })
    UserInfo queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);





}