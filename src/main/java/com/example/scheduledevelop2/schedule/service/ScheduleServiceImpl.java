package com.example.scheduledevelop2.schedule.service;

import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import com.example.scheduledevelop2.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    public final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Override
    public ScheduleResponseDto.Create createSchedule(ScheduleRequestDto.Create dto) {

        Schedule schedule = new Schedule(dto);
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto.Create("스케쥴이 생성되엇습니다.", schedule.getId());
    }

    // 전체 일정 조회
    @Override
    public List<ScheduleResponseDto.GetAll> getAllSchedule() {



        return List.of();
    }
}
