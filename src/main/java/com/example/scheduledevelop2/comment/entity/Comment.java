package com.example.scheduledevelop2.comment.entity;

import com.example.scheduledevelop2.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Schedule scheduleId;
    private String content;

}
