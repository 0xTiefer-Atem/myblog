package org.myblog.project.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author WangQian
 * @Date 2020/9/26 下午 7:14
 */

/**
 * 状态返回
 */
@Getter
public enum ResultCode {
    /**
     * 增删改查操作成功
     */
    OPT_SUCCESS(2000, "成功"),
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

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
