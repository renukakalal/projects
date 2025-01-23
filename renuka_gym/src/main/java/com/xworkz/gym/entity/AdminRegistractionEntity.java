package com.xworkz.gym.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@NamedQuery(name="getRegDetails",query = "select ls from AdminRegistractionEntity ls")
@NamedQuery(name = "updateRegisterDetailsById", query = "UPDATE AdminRegistractionEntity a SET a.packaged=:getPackaged,a.name=:SetName,a.trainer=:getTrainer,a.amount=:getAmount,a.balance=:getBalance where a.id=:getId")



@Data
@Getter
@Setter
@Entity
@Table(name="adminRegister_details")
public class AdminRegistractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="gymName")
    private String gymName;


    @Column(name="trainer")
    private String trainer;


    @Column(name="packaged")
    private String packaged;


    @Column(name="discount")
    private String discount;


    @Column(name="amount")
    private double amount;

    @Column(name="balance")
    private double balance;

    @Column(name="instalment")
    private String instalment;


}
