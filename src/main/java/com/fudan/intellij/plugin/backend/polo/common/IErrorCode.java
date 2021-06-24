package com.fudan.intellij.plugin.backend.polo.common;

/**
 * 错误码接口
 */

public interface IErrorCode {

    /**
     * 获取结果码
     *
     * @return 结果码
     */
    long getCode();

    /**
     * 返回结果信息
     *
     * @return 结果信息
     */
    String getMessage();
}

