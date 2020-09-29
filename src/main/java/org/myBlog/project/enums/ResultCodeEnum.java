package org.myBlog.project.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author WangQian
 * @Date 2020/9/26 下午 7:14
 */

/**
 * 状态返回枚举
 */
@Getter
public enum ResultCodeEnum {
    /**
     * 查询失败
     */
    SELECT_ERROR(5001, "查询失败"),
    /**
     * 添加失败
     */
    INSERT_ERROR(5002, "添加失败"),
    /**
     * 删除失败
     */
    DELETE_ERROR(50001, "删除失败"),
    /**
     * 更新失败
     */
    UPDATE_ERROR(50001, "更新失败");


    private int code;
    private String msg;

    ResultCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
