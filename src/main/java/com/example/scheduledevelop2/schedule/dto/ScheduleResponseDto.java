package com.example.scheduledevelop2.schedule.dto;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleResponseDto {

    @Getter
    @AllArgsConstructor
    public static class Success{
        private final String message;
    }

    @Getter
    @AllArgsConstructor
    public static class Create{
        private final String message;
        private final Long scheduleId;
    }

    @Getter
    @AllArgsConstructor
    public static class GetAll{

        private final Long scheduleId;
        private final Long writerId;
        private final String name;
        private final Long commentCount;

        public GetAll(Schedule schedule, Long commentCount) {
            this.scheduleId = schedule.getId();
            this.writerId = schedule.getWriterId();
            this.name = schedule.getName();
            this.commentCount = commentCount;

        }

    }

    @Getter
    @AllArgsConstructor
    public static class GetById{

        private final Long scheduleId;
        private final Long writerId;
        private final String name;
        private final String content;
        private final Long commentCount;
        private final List<CommentDto.Detail> comments;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private final LocalDateTime createdAt;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        private final LocalDateTime updatedAt;

        public GetById(Schedule schedule, Long commentCount) {
            this.scheduleId = schedule.getId();
            this.writerId = schedule.getWriterId();
            this.name = schedule.getName();
            this.content = schedule.getContent();
            this.commentCount = commentCount;
            this.createdAt = schedule.getCreatedAt();
            this.updatedAt = schedule.getUpdatedAt();

            // comment 필드 리스트 타입을 DTO 클래스로 변환해서 엔티티간 무한 참조 방지
            List<CommentDto.Detail> commentList = new ArrayList<>();
            for (Comment comment : schedule.getComments()) {
                CommentDto.Detail dto = new CommentDto.Detail(
                        comment.getId(),
                        comment.getContent(),
                        comment.getCreatedAt(),
                        comment.getUpdatedAt()
                );
                commentList.add(dto);
            }

            this.comments = commentList;
        }

    }

}
