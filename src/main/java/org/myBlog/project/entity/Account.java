package org.myBlog.project.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Account {
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 用户id
     */
    private String userNo;
    /**
     * 账户
     */
    private String userAccount;
    /**
     * 密码
     */
    private String userPwd;
    /**
     * 创建时间
     */
    private Date createTime;
}