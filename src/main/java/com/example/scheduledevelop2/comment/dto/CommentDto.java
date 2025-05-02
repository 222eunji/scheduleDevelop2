package com.example.scheduledevelop2.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    @AllArgsConstructor
    public static class Request {
        private String content;
    }

    @Getter
    @AllArgsConstructor
    public static class Success {
        private String message;
    }

    @Getter
    @AllArgsConstructor
    public static class GetById {
        private Long commentId;
        private String content;
        private Long scheduleId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
