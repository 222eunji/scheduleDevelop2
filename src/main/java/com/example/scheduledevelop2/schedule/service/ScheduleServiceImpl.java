package com.example.scheduledevelop2.schedule.service;

import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import com.example.scheduledevelop2.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    public final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponseDto.Create createSchedule(ScheduleRequestDto.Create dto) {

        Schedule schedule = new Schedule(dto);
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto.Create("스케쥴이 생성되엇습니다.", schedule.getId());
    }
}
