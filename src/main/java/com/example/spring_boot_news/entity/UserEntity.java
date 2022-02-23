package com.example.spring_boot_news.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends AbstructEntity {

    @Column(name = "username")
    private String userName;

    @Column()
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column()
    private Integer status;

    @ManyToMany()
    @JoinTable(name = "user_role",  //create intermediate table
        joinColumns = @JoinColumn(name = "user_id"),  //create FOREIGN KEY intend for user table
        inverseJoinColumns = @JoinColumn(name = "role_id")  //create FOREIGN KEY intend for role table
    )
    private List<RoleEntity> roles = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
