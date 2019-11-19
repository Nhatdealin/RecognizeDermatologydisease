package com.example.recognizedermatologydisease.models;

import com.google.gson.annotations.SerializedName;

public class ContentBlogPost {

    @SerializedName("id")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("shortContent")
    private String  shortContent;
    @SerializedName("thumbnailImage")
    private String thumbnailImage;
    @SerializedName("blogPostTopic")
    private BlogPostTopic blogPostTopic;
    @SerializedName("createdAt")
    private Long createdAt;
    @SerializedName("createdBy")
    private CreatedBy createdBy;
    @SerializedName("updatedBy")
    private CreatedBy  updatedBy;
    @SerializedName("status")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String  getShortContent() {
        return shortContent;
    }

    public void setShortContent(String  shortContent) {
        this.shortContent = shortContent;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public BlogPostTopic getBlogPostTopic() {
        return blogPostTopic;
    }

    public void setBlogPostTopic(BlogPostTopic blogPostTopic) {
        this.blogPostTopic = blogPostTopic;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdDate) {
        this.createdAt = createdDate;
    }

    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    public CreatedBy  getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(CreatedBy  updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
