package org.myBlog.project.enums;

import lombok.Getter;

/**
 * @Author WangQian
 * @Date 2020/9/29 下午 2:58
 */

/**
 * 博客状态
 */
@Getter
public enum BlogStatusEnum {
    DELETE(-1, "已删除"),
    USE(1, "正在使用"),
    SPECIAL(2, "工作经历或者在校经历");

    private int status;
    private String msg;

    BlogStatusEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
