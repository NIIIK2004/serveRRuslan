package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lesson_contents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String paragraph;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
