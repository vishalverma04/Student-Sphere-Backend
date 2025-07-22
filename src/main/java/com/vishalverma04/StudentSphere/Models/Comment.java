package com.vishalverma04.StudentSphere.Models;
import java.time.LocalDateTime;

public class Comment {
    private String userId;
    private String userName;
    private String content;
    private LocalDateTime commentedAt;

    public Comment(String userId, String userName, String content, LocalDateTime commentedAt) {
        this.userId = userId;
        this.userName = userName;
        this.content = content;
        this.commentedAt = commentedAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(LocalDateTime commentedAt) {
        this.commentedAt = commentedAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                ", commentedAt=" + commentedAt +
                '}';
    }
}

