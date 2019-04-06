package com.aditya_bhatt.models;

public class AlbumListModel {
    private String albumId;
    private String id;
    private String url;
    private String thumbnail;
    private String title;

    public AlbumListModel() {

    }

    public AlbumListModel(String albumId, String id, String url, String thumbnail, String title) {
        this.albumId = albumId;
        this.id = id;
        this.url = url;
        this.thumbnail = thumbnail;
        this.title = title;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}