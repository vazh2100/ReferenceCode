package com.vazheninapps.chatapp;

class Message {
    private String author;
    private String message;
    private Long date;
    private String imageUrl;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Message() {
    }

    public Message(String author, String message, long date, String imgUrl) {
        this.author = author;
        this.message = message;
        this.date = date;
        this.imageUrl = imgUrl;
    }
}
