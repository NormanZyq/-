package com.neuedu.project.domain;

public enum MyHttpStatus {

    /**
     * 一切成功都是这个
     */
    OK(200, "OK"),

    /**
     * 登录失败，用户名密码不匹配
     */
    FAIL(701, "FAIL"),

    /**
     * 用户名或密码为空
     */
    EMPTY(702, "EMPTY");

    private final int value;

    private final String reasonPhrase;

    MyHttpStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return value;
    }

    public String reasonPhrase() {
        return reasonPhrase;
    }
}
