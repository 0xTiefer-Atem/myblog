package org.myblog.project.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_account
 * @author 
 */
@Data
public class UserAccount {
    private String userId;

    private String userAccount;

    private String userPwd;

    private Date createTime;
}