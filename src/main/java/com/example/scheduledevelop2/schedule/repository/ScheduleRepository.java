package com.example.scheduledevelop2.schedule.repository;

import com.example.scheduledevelop2.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long scheduleId) {
        return findById(scheduleId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 일정입니다.")); //todo: 예외 바꾸기
    }

}
