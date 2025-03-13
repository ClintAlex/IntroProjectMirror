package com.internship.introproject.dto;

public class AlbumsDTO {

    private long id;
    private int userId;
    private String title;

    public AlbumsDTO() {
    }

    public AlbumsDTO(long id, int userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
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
