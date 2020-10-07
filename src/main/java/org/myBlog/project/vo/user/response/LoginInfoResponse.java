package org.myBlog.project.vo.user.response;

/**
 * @Author WangQian
 * @Date 2020/10/7 下午 8:02
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登陆成功返回字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginInfoResponse {
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
}
