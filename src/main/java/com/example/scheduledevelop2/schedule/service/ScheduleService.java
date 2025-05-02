package com.example.scheduledevelop2.schedule.service;

import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto.Create createSchedule(ScheduleRequestDto.Create dto);

    List<ScheduleResponseDto.GetAll> getAllSchedule();

    ScheduleResponseDto.GetById getScheduleById(Long scheduleId);

    ScheduleResponseDto.Success updateSchedule(Long scheduleId, ScheduleRequestDto.Update dto);
}
