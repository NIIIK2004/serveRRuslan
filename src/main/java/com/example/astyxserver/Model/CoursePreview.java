package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course_previews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursePreview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
