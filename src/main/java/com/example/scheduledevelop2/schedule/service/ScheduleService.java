package com.example.scheduledevelop2.schedule.service;

import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;

public interface ScheduleService {
    ScheduleResponseDto.Create createSchedule(ScheduleRequestDto.Create dto);
}
