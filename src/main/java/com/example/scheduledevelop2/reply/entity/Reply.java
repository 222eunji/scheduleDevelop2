package com.example.scheduledevelop2.reply.entity;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.common.BaseEntity;
import com.example.scheduledevelop2.reply.dto.ReplyDto;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "reply")
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(nullable = false)
    private String content;

    public Reply(Comment comment, ReplyDto.Request dto) {
        this.comment = comment;
        this.content = dto.getContent();
    }

    public void update(ReplyDto.Request dto) {
        this.content = dto.getContent();
    }
}
