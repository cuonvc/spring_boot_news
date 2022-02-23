package com.example.spring_boot_news.entity;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class NewsEntity extends AbstructEntity {

    @Column()
    private String title;

    @Column()
    private String content;

    @Column(name = "shortdescription")
    private String shortDescription;

    @Column()
    private String thumbnail;

    @ManyToOne()
    @JoinColumn(name = "categoryid")
    private CategoryEntity category;

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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
