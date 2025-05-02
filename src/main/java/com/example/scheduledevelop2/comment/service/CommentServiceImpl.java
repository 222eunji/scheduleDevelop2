package com.example.scheduledevelop2.comment.service;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.comment.repository.CommentRepository;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import com.example.scheduledevelop2.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    public final CommentRepository commentRepository;
    public final ScheduleRepository scheduleRepository;

    // 댓글 생성
    @Override
    public CommentDto.Success createComment(Long scheduleId, CommentDto.Request dto) {

        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
        Comment comment = new Comment(schedule, dto);
        commentRepository.save(comment);

        return new CommentDto.Success("댓글이 작성되었습니다.");
    }

    // 댓글 조회
    @Override
    public CommentDto.GetById getCommentById(Long commentId) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);

        return new CommentDto.GetById(comment);
    }

    // 댓글 수정
    @Override
    @Transactional
    public CommentDto.Success updateComment(Long commentId, CommentDto.Request dto) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);
        comment.update(dto);

        return new CommentDto.Success("댓글이 수정되었습니다.");
    }

    // 댓글 삭제
    @Override
    public CommentDto.Success deleteComment(Long commentId) {

        Comment comment = commentRepository.findByIdOrElseThrow(commentId);
        commentRepository.delete(comment);

        return new CommentDto.Success("댓글이 삭제되었습니다.");
    }
}