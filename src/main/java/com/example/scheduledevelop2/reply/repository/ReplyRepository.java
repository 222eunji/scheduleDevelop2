package com.example.scheduledevelop2.reply.repository;

import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.common.exception.CustomException;
import com.example.scheduledevelop2.common.exception.ErrorCode;
import com.example.scheduledevelop2.reply.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    default Reply findByIdOrElseThrow(Long replyId) {
        return findById(replyId).orElseThrow(()-> new CustomException(ErrorCode.REPLY_NOT_FOUND));

    }

}
