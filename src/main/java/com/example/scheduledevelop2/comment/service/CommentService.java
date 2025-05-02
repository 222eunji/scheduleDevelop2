package com.example.scheduledevelop2.comment.service;

import com.example.scheduledevelop2.comment.dto.CommentDto;

public interface CommentService {
    CommentDto.Success createComment(Long scheduleId, CommentDto.Request dto);

    CommentDto.GetById getCommentById(Long commentId);

    CommentDto.Success updateComment(Long commentId, CommentDto.Request dto);

    CommentDto.Success deleteComment(Long commentId);
}
