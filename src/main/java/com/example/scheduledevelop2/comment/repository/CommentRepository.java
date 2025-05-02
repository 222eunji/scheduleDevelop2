package com.example.scheduledevelop2.comment.repository;

import com.example.scheduledevelop2.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
