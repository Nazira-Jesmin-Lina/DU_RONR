package com.example.codesamurai_du_ronr;

public class Comment {
    private String commentText,commentedby;
    private long commentedAt;

    public Comment() {

    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }


    public long getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(long commentedAt) {
        this.commentedAt = commentedAt;
    }

    public String getCommentedby() {
        return commentedby;
    }

    public void setCommentedby(String commentedby) {
        this.commentedby = commentedby;
    }
}
