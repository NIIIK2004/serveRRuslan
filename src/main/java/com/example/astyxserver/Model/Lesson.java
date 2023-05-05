package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theme;
    private String description;
    @OneToMany(mappedBy = "lesson")
    private List<LessonContent> content;
    @OneToMany(mappedBy = "lesson")
    private List<LessonMedia> media;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
