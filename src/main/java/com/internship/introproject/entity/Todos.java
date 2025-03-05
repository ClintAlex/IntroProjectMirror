package com.internship.introproject.entity;

import jakarta.persistence.*;
import jdk.jfr.BooleanFlag;
import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseConverter;

import java.util.BitSet;

@Entity
@Table(name = "todos")
public class Todos {
    @Id
    private Long id;

    @Column(name = "userId", nullable = false)
    private int userId;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(name = "completed")
    private Boolean completed;

    public Todos() {
    }

    private Todos(Long id, int userId, String title, Boolean completed){
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
