package com.example.scheduledevelop2.schedule.controller;

import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop2.schedule.service.ScheduleService;
import com.example.scheduledevelop2.schedule.service.ScheduleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    final ScheduleService scheduleService;

    /**
     * 일정 생성
     * @param dto Id,제목,내용 받는 Dto
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto.Create> createSchedule(@RequestBody ScheduleRequestDto.Create dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(dto));
    }


}
