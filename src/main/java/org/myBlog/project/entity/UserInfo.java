package org.myBlog.project.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 个人信息(UserInfo)实体类
 *
 * @author makejava
 * @since 2020-05-27 10:42:46
 */
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
    
    private String userSkillInfoList;
    
    private Date createTime;

}