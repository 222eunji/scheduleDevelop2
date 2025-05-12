package com.example.scheduledevelop2.comment.repository;

import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.common.exception.CustomException;
import com.example.scheduledevelop2.common.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment findByIdOrElseThrow(Long commentId) {
        return findById(commentId).orElseThrow(()-> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
    }

    Long countBySchedule_Id(Long ScheduleId);
}
