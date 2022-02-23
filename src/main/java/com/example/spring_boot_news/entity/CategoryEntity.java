package com.example.spring_boot_news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity extends AbstructEntity {

    @Column()
    private String code;

    @Column()
    private String name;

    @OneToMany(mappedBy = "category")  //this "category" is generated from "category" property in NewsEntity class
    private List<NewsEntity> newsList = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NewsEntity> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsEntity> newsList) {
        this.newsList = newsList;
    }
}
