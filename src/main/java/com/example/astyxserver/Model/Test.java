package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int complexity;
    private boolean isPaid;
    private int price;
    @OneToMany(mappedBy = "test")
    private List<Question> question;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "test")
    private List<Favorite> favorites;
    @OneToMany(mappedBy = "test")
    private List<AuthorMaterial> authorMaterials;
    @OneToMany(mappedBy = "test")
    private List<Progress> progress;
}
