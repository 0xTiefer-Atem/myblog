package org.myBlog.project.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user_account
 *
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccount {
    /**
     * 用户id
     * */
    private String userId;
    /**
     * 账户
     * */
    private String userAccount;
    /**
     * 密码
     * */
    private String userPwd;
    /**
     * 创建时间
     * */
    private Date createTime;
}