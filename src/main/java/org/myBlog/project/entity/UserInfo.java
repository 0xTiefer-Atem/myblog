package org.myBlog.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myBlog.project.vo.bolg.response.RelatedLinks;
import org.myBlog.project.vo.bolg.response.SkillInfo;

import java.util.Date;
import java.util.List;

/**
 * 个人信息(UserInfo)实体类
 *
 * @author makejava
 * @since 2020-05-27 10:42:46
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户编号
     */
    private String userNo;
    /**
     * 头像
     */
    private String userAvatar;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 座右铭
     */
    private String userMotor;
    /**
     * 相关链接
     */
    private String userRelatedLinks;
    /**
     * 技能列表
     */
    private String userSkillInfoList;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}