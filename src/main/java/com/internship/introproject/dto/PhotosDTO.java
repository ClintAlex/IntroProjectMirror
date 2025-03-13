package com.internship.introproject.dto;

public class PhotosDTO {

    private long id;
    private int albumId;
    private String title;
    private String url;
    private String thumbnailUrl;

    public PhotosDTO() {
    }

    public PhotosDTO(long id, int albumId, String title, String url, String thumbnailUrl) {
        this.id = id;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getAlbumId() {
        return albumId;
    }
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
