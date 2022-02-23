package com.example.spring_boot_news.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
public class RoleEntity extends AbstructEntity {

    @Column()
    private String code;

    @Column()
    private String name;

    @ManyToMany(mappedBy = "roles")  //this "roles" is generated from "roles" property in UserEntity class
    private List<UserEntity> users = new ArrayList<>();

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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
