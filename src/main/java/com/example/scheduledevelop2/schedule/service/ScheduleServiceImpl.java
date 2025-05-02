package com.example.scheduledevelop2.schedule.service;

import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import com.example.scheduledevelop2.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//        boolean exists = scheduleRepository.count() == 0;
        // count 말고 isnotnull과 같이 존재 여부만 확인하고 싶다.
        // TODO: 일정 0일때 조회 목록 없음 예외처리하기

        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto.GetAll> response =  new ArrayList<>();

        for (Schedule schedule : schedules) {
            response.add(new ScheduleResponseDto.GetAll(schedule));
        }

        return response;
    }
}
