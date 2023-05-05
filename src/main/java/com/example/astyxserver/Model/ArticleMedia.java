package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "article_media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
