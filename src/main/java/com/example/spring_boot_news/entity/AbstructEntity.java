package com.example.spring_boot_news.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass  //generate table into class
@EntityListeners(AuditingEntityListener.class)   //related createdData and modifiedDate
public abstract class AbstructEntity {

    @Id  //set NOT NULL & PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) //set auto_increment id
    private Long id;

    @Column(name = "createdby")  //generate filds of table into sql
    private String createdBy;

    @Column(name = "createddate")
    @CreatedDate
    private Date createdDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

    @Column(name = "modifieddate")
    @LastModifiedDate
    private Date modifiedDate;

    public Long getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
