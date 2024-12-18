package com.xworkz.commonmodule.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="module_table")
public class ModuleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="user_name")
    private String name;
    @Column(name="user_email")
    private String email;
    @Column(name="altEmail")
    private String alternativeEmail;

    public long getAlternativePhoneNumber() {
        return alternativePhoneNumber;
    }

    public void setAlternativePhoneNumber(long alternativePhoneNumber) {
        this.alternativePhoneNumber = alternativePhoneNumber;
    }

    @Column(name="user_phNumber")
    private long phoneNumber;
    @Column(name="altph_Number")
    private long alternativePhoneNumber;

    @Column(name="user_location")
    private String location;
    @Column(name="user_password")
    private String password;

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getLocation() {
        return location;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }




    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
