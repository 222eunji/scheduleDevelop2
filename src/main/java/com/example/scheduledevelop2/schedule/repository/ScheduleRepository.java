package com.example.scheduledevelop2.schedule.repository;

import com.example.scheduledevelop2.common.exception.CustomException;
import com.example.scheduledevelop2.common.exception.ErrorCode;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long scheduleId) {
          return findById(scheduleId).orElseThrow(()-> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND));
    }

}
