package com.example.scheduledevelop2.schedule.controller;

import com.example.scheduledevelop2.schedule.service.ScheduleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    final ScheduleServiceImpl scheduleServiceImpl;

}
