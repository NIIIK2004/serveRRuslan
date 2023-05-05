package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String purpose;
    @OneToMany(mappedBy = "course")
    private List<Test> tests;
    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;
    @OneToMany(mappedBy = "course")
    private List<CoursePreview> previews;
    private boolean isPaid;
    private int price;
    @OneToMany(mappedBy = "course")
    private List<Favorite> favorites;
    @OneToMany(mappedBy = "course")
    private List<AuthorMaterial> authorMaterials;
    @OneToMany(mappedBy = "course")
    private List<Progress> progress;
}
