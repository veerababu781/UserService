package com.user.entity;

import org.hibernate.boot.model.relational.Sequence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(name = "id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public User(Long userId, String name, String phone, List<Contact> contacts) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.contacts = contacts;
    }

    public User(Long userId, String name, String phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }
}
