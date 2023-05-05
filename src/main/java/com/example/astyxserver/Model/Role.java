package com.example.astyxserver.Model;

public enum Role {
    USER("Пользователь"),
    TEACHER("Преподаватель"),
    ADMIN("Администратор");

    private final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
