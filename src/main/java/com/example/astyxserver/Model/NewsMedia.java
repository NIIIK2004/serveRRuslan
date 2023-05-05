package com.example.astyxserver.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "news_media")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;
}
