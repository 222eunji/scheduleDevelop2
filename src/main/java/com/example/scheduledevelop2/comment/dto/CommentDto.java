package com.example.scheduledevelop2.comment.dto;

import com.example.scheduledevelop2.comment.entity.Comment;
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
        private final String message;
    }

    @Getter
    @AllArgsConstructor
    public static class GetById {
        private Long commentId;
        private String content;
        private Long scheduleId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public GetById(Comment comment) {
            this.commentId = comment.getId();
            this.content = comment.getContent();
            this.scheduleId = comment.getSchedule().getId();
            this.createdAt = comment.getCreatedAt();
            this.updatedAt = comment.getUpdatedAt();
        }

    }
}
