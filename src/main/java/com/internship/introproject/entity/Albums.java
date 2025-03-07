package com.internship.introproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "albums")
public class Albums {

    @Id
    private Long id;

    @Column(name = "userId", nullable = false)
    private int userId;

    @Column(nullable = false, length = 255)
    private String title;

    public Albums() {
    }

    public Albums(Long id, int userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
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
}