package org.myBlog.project.vo.user.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WangQian
 * @Date 2020/10/7 下午 7:01
 */

/**
 * 登录请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest {
    /**
     * 账户
     */
    private String userAccount;
    /**
     * 密码
     */
    private String userPwd;
}
