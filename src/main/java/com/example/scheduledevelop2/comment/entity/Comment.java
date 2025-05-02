package com.example.scheduledevelop2.comment.entity;

import com.example.scheduledevelop2.comment.dto.CommentDto;
import com.example.scheduledevelop2.common.BaseEntity;
import com.example.scheduledevelop2.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @Column(nullable = false)
    private String content;

    public Comment(Schedule schedule, CommentDto.Request dto) {
        this.schedule = schedule;
        this.content = dto.getContent();
    }

    public void update(CommentDto.Request dto) {
        this.content = dto.getContent();
    }
}
