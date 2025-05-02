package com.example.scheduledevelop2.schedule.dto;

import com.example.scheduledevelop2.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
        private final int commentCount;

        public GetAll(Schedule schedule, int commentCount) {
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
//        private final Long commentCount;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;

        public GetById(Schedule schedule) {
            this.scheduleId = schedule.getId();
            this.writerId = schedule.getWriterId();
            this.name = schedule.getName();
            this.content = schedule.getContent();
//            this.commentCount = schedule.getCommentCount();
            this.createdAt = schedule.getCreatedAt();
            this.updatedAt = schedule.getUpdatedAt();
        }

    }

}
