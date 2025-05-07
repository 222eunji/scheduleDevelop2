package com.example.scheduledevelop2.reply.service;

import com.example.scheduledevelop2.reply.dto.ReplyDto;

public interface ReplyService {
    ReplyDto.Success createReply(Long commentId, ReplyDto.Request dto);

    ReplyDto.GetById getReplyById(Long replyId);

    ReplyDto.Success updateReply(Long replyId, ReplyDto.Request dto);

    ReplyDto.Success deleteReply(Long replyId);
}
