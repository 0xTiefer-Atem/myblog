package org.myBlog.project.vo.user.request;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 4:48
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 跟新用户信息请求参数字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserInfoRequest {
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
