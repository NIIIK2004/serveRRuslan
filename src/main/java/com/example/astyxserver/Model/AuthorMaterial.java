package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "author_materials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = true)
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(optional = true)
    @JoinColumn(name = "test_id")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
