package com.example.astyxserver.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String surname;
        private String number;
        private String file;
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        private LocalDate date;
        @Column(nullable = false)
        private String username;
        @Column(nullable = false, unique = true)
        private String email;
        @Column(nullable = false)
        private String password;
        @Column(nullable = false)
        private boolean active;
        private String activationCode;
        @CollectionTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"))
        @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
        @Enumerated(EnumType.STRING)
        private Set<Role> roles;
        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<Favorite> favorites;
        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<Progress> progresses;
        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<AuthorMaterial> authorMaterials;
        @JsonIgnore
        @OneToMany(mappedBy = "user")
        private List<Article> article;
    }
