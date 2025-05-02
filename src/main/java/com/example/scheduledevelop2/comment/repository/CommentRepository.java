package com.example.scheduledevelop2.comment.repository;

import com.example.scheduledevelop2.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment findByIdOrElseThrow(Long commentId) {
        return findById(commentId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 댓글입니다.")); //todo: 예외 바꾸기
    }

    Long countBySchedule_Id(Long ScheduleId);
}
