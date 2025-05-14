package com.example.scheduledevelop2.reply.service;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.comment.repository.CommentRepository;
import com.example.scheduledevelop2.comment.service.CommentService;
import com.example.scheduledevelop2.reply.dto.ReplyDto;
import com.example.scheduledevelop2.reply.entity.Reply;
import com.example.scheduledevelop2.reply.repository.ReplyRepository;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import com.example.scheduledevelop2.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;

    // 대댓글 생성
    @Override
    public ReplyDto.Success createReply(Long commentId, ReplyDto.Request dto) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);
        Reply reply = new Reply(comment, dto);
        replyRepository.save(reply);

        return new ReplyDto.Success("답글이 작성되었습니다.");
    }

    // 대댓글 조회
    @Override
    public ReplyDto.GetById getReplyById(Long replyId) {

        Reply reply = replyRepository.findByIdOrElseThrow(replyId);
//        Comment comment = commentRepository.findByIdOrElseThrow(reply.getComment().getId());

        return new ReplyDto.GetById(reply, reply.getComment());
    }

    // 대댓글 수정
    @Override
    @Transactional
    public ReplyDto.Success updateReply(Long replyId, ReplyDto.Request dto) {

        Reply reply = replyRepository.findByIdOrElseThrow(replyId);
        reply.update(dto);

        return new ReplyDto.Success("답글이 수정되었습니다.");
    }

    // 대댓글 삭제
    @Override
    public ReplyDto.Success deleteReply(Long replyId) {

        Reply reply = replyRepository.findByIdOrElseThrow(replyId);
        replyRepository.delete(reply);

        return new ReplyDto.Success("답글이 삭제되었습니다.");
    }
}