package com.example.scheduledevelop2.comment.controller;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class CommentController {

    public final CommentService commentService;

    /**
     * 댓글 생성
     * @param scheduleId 댓글 달 일정 ID
     * @param dto 댓글 내용
     * @return API 응답 성공 메세지
     */
    @PostMapping("/{scheduleId}/comment")
    public ResponseEntity<CommentDto.Success> createComment (@PathVariable Long scheduleId,
                                                             @RequestBody CommentDto.Request dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(scheduleId,dto));
    }

}
