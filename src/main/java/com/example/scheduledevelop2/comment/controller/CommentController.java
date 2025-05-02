package com.example.scheduledevelop2.comment.controller;

import com.example.scheduledevelop2.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommentController {

    public final CommentService commentService;


}
