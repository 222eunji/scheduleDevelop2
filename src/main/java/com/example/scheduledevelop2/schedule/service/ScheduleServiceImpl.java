package com.example.scheduledevelop2.schedule.service;

import com.example.scheduledevelop2.comment.repository.CommentRepository;
import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import com.example.scheduledevelop2.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    public final ScheduleRepository scheduleRepository;
    public final CommentRepository commentRepository;

    // 일정 생성
    @Override
    public ScheduleResponseDto.Create createSchedule(ScheduleRequestDto.Create dto) {

        Schedule schedule = new Schedule(dto);
        scheduleRepository.save(schedule);

        return new ScheduleResponseDto.Create("일정이 생성되었습니다.", schedule.getId());
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
            int commentCount = commentRepository.countBySchedule_Id(schedule.getId());
            response.add(new ScheduleResponseDto.GetAll(schedule,commentCount));
        }

        return response;
    }

    // 일정 단건 조회
    @Override
    public ScheduleResponseDto.GetById getScheduleById(Long scheduleId) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);

        return new ScheduleResponseDto.GetById(schedule);
    }

    // 일정 수정
    @Override
    @Transactional
    public ScheduleResponseDto.Success updateSchedule(Long scheduleId, ScheduleRequestDto.Update dto) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
        schedule.update(dto);

        return new ScheduleResponseDto.Success("일정이 수정되었습니다.");
    }

    // 일정 삭제
    @Override
    public ScheduleResponseDto.Success deleteSchedule(Long scheduleId) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
        scheduleRepository.delete(schedule);

        return new ScheduleResponseDto.Success("일정이 삭제되었습니다.");
    }
}
