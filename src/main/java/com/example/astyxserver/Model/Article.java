package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "articles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String content;
    @OneToMany(mappedBy = "article")
    private List<ArticleMedia> media;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
