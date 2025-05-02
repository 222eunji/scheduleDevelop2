package com.example.scheduledevelop2.schedule.controller;

import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import com.example.scheduledevelop2.schedule.dto.ScheduleResponseDto;
import com.example.scheduledevelop2.schedule.service.ScheduleService;
import com.example.scheduledevelop2.schedule.service.ScheduleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {

    final ScheduleService scheduleService;

    /**
     * 일정 생성
     * @param dto 작성자ID, 제목, 내용
     * @return 응답 성공 메세지
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto.Create> createSchedule(@RequestBody ScheduleRequestDto.Create dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.createSchedule(dto));
    }

    /***
     * 전체 일정 조회
     * @return (일정ID, 작성자ID, 제목, 댓글 수) 리스트
     */
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto.GetAll>> getAllSchedule() {

        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAllSchedule());
    }

    /**
     * 단건 일정 조회
     * @param scheduleId
     * @return 일정 상세 정보(일정ID, 작성자ID, 제목, 내용, 댓글 수, 생성일, 수정일)
     */
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto.GetById> getScheduleById(@PathVariable Long scheduleId) {
        
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getScheduleById(scheduleId));
    }

    /**
     * 일정 수정
     * @param scheduleId
     * @param dto 제목, 내용 수정 가능
     * @return 응답 성공 메세지
     */
    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto.Success> updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleRequestDto.Update dto) {

        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.updateSchedule(scheduleId, dto));
    }

    /**
     * 일정 삭제
     * @param scheduleId
     * @return 응답 성공 메세지
     */
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto.Success> deleteSchedule(@PathVariable Long scheduleId) {

        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.deleteSchedule(scheduleId));
    }
}
