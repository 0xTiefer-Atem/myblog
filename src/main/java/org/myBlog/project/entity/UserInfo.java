package org.myblog.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.myblog.project.vo.bolg.response.RelatedLinks;
import org.myblog.project.vo.bolg.response.SkillInfo;

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
public class UserInfo {
    /**
    * id
    */
    private Integer userId;
    /**
     * 头像
     * */
    private String userAvatar;
    /**
     * 用户名称
     * */
    private String userName;
    /**
     * 座右铭
     * */
    private String userMotor;
    /**
     * 相关链接
     * */
    private String userRelatedLinks;
    /**
     * 链接json
     * */
    private List<RelatedLinks> userRelatedLinksJson;
    /**
     * 技能列表
     * */
    private String userSkillInfoList;
    /**
     * 技能列表json
     * */
    private List<SkillInfo> userSkillInfoListJson;
    /**
     * 创建时间
     * */
    private Date createTime;

}