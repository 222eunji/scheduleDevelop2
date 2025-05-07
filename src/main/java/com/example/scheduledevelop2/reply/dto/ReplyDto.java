package com.example.scheduledevelop2.reply.dto;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.reply.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReplyDto {

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
        private CommentDto.Detail comment;
        private Long replyId;
        private String content;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public GetById(Reply reply, Comment comment) {
            this.comment = new CommentDto.Detail(comment);
            this.replyId = reply.getId();
            this.content = reply.getContent();
            this.createdAt = reply.getCreatedAt();
            this.updatedAt = reply.getUpdatedAt();
        }

    }

}
