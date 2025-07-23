package com.vishalverma04.StudentSphere.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "questions")
public class QuestionModel {
    @Id
    private String id;

    private String title;
    private String content;

    private String company;             // e.g., Amazon, Google
    private String questionType;        // OA, Coding Round, Interview
    private String difficultyLevel;     // Easy, Medium, Hard

    private List<String> tags;          // e.g., ["array", "sliding-window"]
    private List<String> topics;        // e.g., ["Data Structures", "Algorithms"]

    private LocalDate askedDate;    // When asked in interview
    private LocalDate uploadedAt;   // Upload time
    private String uploadedBy;          // User ID or email

    private int likes;

    private List<Comment> comments;     // Embedded comments

    private boolean verified;           // Verified by moderator


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public LocalDate getAskedDate() {
        return askedDate;
    }

    public void setAskedDate(LocalDate askedDate) {
        this.askedDate = askedDate;
    }

    public LocalDate getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDate uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", company='" + company + '\'' +
                ", questionType='" + questionType + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", tags=" + tags +
                ", topics=" + topics +
                ", askedDate=" + askedDate +
                ", uploadedAt=" + uploadedAt +
                ", uploadedBy='" + uploadedBy + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", verified=" + verified +
                '}';
    }
}
