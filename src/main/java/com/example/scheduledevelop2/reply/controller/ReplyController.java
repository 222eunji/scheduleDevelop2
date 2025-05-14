package com.example.scheduledevelop2.reply.controller;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.reply.dto.ReplyDto;
import com.example.scheduledevelop2.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    /**
     * 대댓글 생성
     * @param commentId 답글 달 댓글 ID
     * @param dto 대댓글 내용
     * @return 응답 성공 메세지
     */
    @PostMapping("/{commentId}/reply")
    public ResponseEntity<ReplyDto.Success> createReply (@PathVariable Long commentId,
                                                             @RequestBody ReplyDto.Request dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(replyService.createReply(commentId,dto));
    }

    /**
     * 대댓글 조회
     * @param replyId 대댓글 ID
     * @return 댓글 정보(댓글ID, 내용, 일정ID, 생성일, 수정일) -> 원댓글ID, 원댓글 내용, 대댓글ID, 대댓글 내용
     */
    @GetMapping("/reply/{replyId}")
    public ResponseEntity<ReplyDto.GetById> getReplyById (@PathVariable Long replyId) {

        return ResponseEntity.status(HttpStatus.OK).body(replyService.getReplyById(replyId));
    }

    /**
     * 대댓글 수정
     * @param replyId 대댓글 ID
     * @param dto 대댓글 내용
     * @return 응답 성공 메세지
     */
    @PatchMapping("/reply/{replyId}")
    public ResponseEntity<ReplyDto.Success> updateReply (@PathVariable Long replyId,
                                                             @RequestBody ReplyDto.Request dto) {

        return ResponseEntity.status(HttpStatus.OK).body(replyService.updateReply(replyId, dto));
    }

    /**
     * 대댓글 삭제
     * @param replyId 대댓글 ID
     * @return 응답 성공 메세지
     */
    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity<ReplyDto.Success> deleteReply (@PathVariable Long replyId) {

        return ResponseEntity.status(HttpStatus.OK).body(replyService.deleteReply(replyId));
    }

}
