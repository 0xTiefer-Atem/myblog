package org.myBlog.project.vo.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 4:20
 */

/**
 * 返回用户信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoResponse {
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
}
