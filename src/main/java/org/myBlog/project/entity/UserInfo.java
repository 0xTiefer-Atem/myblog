package org.myBlog.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;
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
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -53057680481856769L;
    /**
    * id
    */
    private Integer userId;
    
    private String userAvatar;
    
    private String userName;
    
    private String userMotor;
    
    private String userRelatedLinks;
    private List<RelatedLinks> userRelatedLinksJson;

    private String userSkillInfoList;
    private List<SkillInfo> userSkillInfoListJson;

    private Date createTime;

}