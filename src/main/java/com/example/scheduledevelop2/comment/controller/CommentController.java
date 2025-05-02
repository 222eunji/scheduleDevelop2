package com.example.scheduledevelop2.comment.controller;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CommentController {

    public final CommentService commentService;

    /**
     * 댓글 생성
     * @param scheduleId 댓글 달 일정 ID
     * @param dto 댓글 내용
     * @return 응답 성공 메세지
     */
    @PostMapping("/{scheduleId}/comment")
    public ResponseEntity<CommentDto.Success> createComment (@PathVariable Long scheduleId,
                                                             @RequestBody CommentDto.Request dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(scheduleId,dto));
    }

    /**
     * 댓글 조회
     * @param commentId
     * @return 댓글 정보(댓글ID, 내용, 일정ID, 생성일, 수정일)
     */
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<CommentDto.GetById> getCommentById (@PathVariable Long commentId) {

        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentById(commentId));
    }

    /**
     * 댓글 수정
     * @param commentId
     * @param dto 댓글 내용
     * @return 응답 성공 메세지
     */
    @PatchMapping("/comment/{commentId}")
    public ResponseEntity<CommentDto.Success> updateComment (@PathVariable Long commentId,
                                                             @RequestBody CommentDto.Request dto) {

        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateComment(commentId, dto));
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<CommentDto.Success> deleteComment (@PathVariable Long commentId) {

        return ResponseEntity.status(HttpStatus.OK).body(commentService.deleteComment(commentId));
    }

}
