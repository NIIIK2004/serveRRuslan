package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lesson_medias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
