package com.example.scheduledevelop2.schedule.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ScheduleRequestDto {

    @Getter
    @AllArgsConstructor
    public static class Create{

        private Long writerId;
        private String name;
        private String content;
    }

    @Getter
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Update{

        private String name;
        private String content;
    }
}
