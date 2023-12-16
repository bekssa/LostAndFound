package com.example.demo2.model;

public class Post {
    private String statusType;
    private String imagePath;
    private String comment;
    private String author;

    public Post(String statusType, String imagePath, String comment, String author) {
        this.statusType = statusType;
        this.imagePath = imagePath;
        this.comment = comment;
        this.author = author;
    }

    public String getStatusType() {
        return statusType;
    }



    public String getImagePath() {
        return imagePath;
    }
    public String getComment() {
        return comment;
    }


    public String getAuthor() {
        return author;
    }

    public void commentSplitter(){

    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
};
