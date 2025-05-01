package com.example.scheduledevelop2.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
        private final Long commentCount;

    }

    @Getter
    @AllArgsConstructor
    public static class GetById{

        private final Long scheduleId;
        private final Long writerId;
        private final String name;
        private final Long commentCount;
        private final LocalDateTime createdAt;
        private final LocalDateTime updatedAt;
    }

}
