package com.example.project_akhir_bp3;

public class Hero {
    private String id;
    private String title;
    private String synopsis;
    private String type;
    private String published;
    private String gendre;
    private String authors;
    private String score;
    private String capter;

    private int photo;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getGendre() {
        return gendre;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getScore() {return score;}

    public void setScore(String score) {this.score = score;}

    public String getCapter() {return capter;}

    public void setCapter(String capter) {this.capter = capter;}

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
