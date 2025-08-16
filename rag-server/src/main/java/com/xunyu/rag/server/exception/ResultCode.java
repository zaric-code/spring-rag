package com.xunyu.rag.server.exception;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS("0", "操作成功"),

    FAILURE("100", "业务异常");

    private String code;

    private String msg;

    ResultCode(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

}
