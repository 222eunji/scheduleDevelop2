package com.example.scheduledevelop2.schedule.entity;

import com.example.scheduledevelop2.comment.entity.Comment;
import com.example.scheduledevelop2.common.BaseEntity;
import com.example.scheduledevelop2.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

//    @ColumnDefault("0")
//    @Formula("(select count(*) from comment c where c.schedule_id = id")
//    private Long commentCount;
    // 이렇게 필드를 만들어버리면 comment에 변화가 있을 때 마다 쿼리가 한번 더 사용됨

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("createdAt asc")
    private List<Comment> comments;

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
