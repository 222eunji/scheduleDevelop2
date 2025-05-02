package com.example.scheduledevelop2.comment.service;

import com.example.scheduledevelop2.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    public final CommentRepository commentRepository;

}
