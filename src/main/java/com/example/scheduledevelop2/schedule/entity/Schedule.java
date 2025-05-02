package com.example.scheduledevelop2.schedule.entity;

import com.example.scheduledevelop2.common.BaseEntity;
import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "schedules")
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long writerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ColumnDefault("0")
    private Long commentCount;

//    @OneToMany(mappedBy = "schedule")
//    private List<Comment> comments = new ArrayList<>();

    public Schedule(ScheduleRequestDto.Create dto) {
        this.writerId = dto.getWriterId();
        this.name = dto.getName();
        this.content = dto.getContent();
    }

    public void update(ScheduleRequestDto.Update dto) {
        if(dto.getName() != null) this.name = dto.getName();
        if(dto.getContent() != null) this.content = dto.getContent();
    }


}
