package com.example.scheduledevelop2.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // Schedule
    SCHEDULE_NOT_FOUND(404, "NON Found", "S001", "존재하지 않는 일정입니다."),

    // Comment
    COMMENT_NOT_FOUND(404, "NON Found", "C001", "존재하지 않는 댓글입니다."),

    // Reply
    REPLY_NOT_FOUND(404, "NON Found", "R001", "존재하지 않는 답글입니다.");


    private final int status;
    private final String error;
    private final String code;
    private final String message;

}
