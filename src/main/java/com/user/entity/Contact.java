package com.user.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT")
public class Contact {

    @Id
    @Column(name="CID")
    private Long cId;
    private String email;
    private String contactName;

    @ManyToOne
    private User user;

    public Contact() {
    }

    public Contact(Long cId, String email, String contactName) {
        this.cId = cId;
        this.email = email;
        this.contactName = contactName;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
