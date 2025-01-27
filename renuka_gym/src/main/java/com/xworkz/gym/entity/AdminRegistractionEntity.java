package com.xworkz.gym.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NamedQuery(name="getRegDetails",query = "select ls from AdminRegistractionEntity ls")
@NamedQuery(name = "updateRegisterDetailsById", query = "UPDATE AdminRegistractionEntity a SET a.packaged=:getPackaged,a.name=:SetName,a.trainer=:getTrainer,a.amount=:getAmount,a.balance=:getBalance where a.id=:getId")
@NamedQuery(name = "findUserEmailAndPassword", query = "SELECT a FROM AdminRegistractionEntity a WHERE a.email = :SetEmail")
//@NamedQuery(name = "updateByEmail",query = "UPDATE AdminRegistractionEntity a SET  a.filePath = :filePath WHERE a.email = :SetEmail")
@NamedQuery(name = "updateById",
        query = "UPDATE AdminRegistractionEntity a SET " +
                "a.name = :name, a.email = :email, a.password = :password, a.gymName = :gymName, " +
                "a.trainer = :trainer, a.packaged = :packaged, a.discount = :discount, " +
                "a.amount = :amount, a.balance = :balance, a.instalment = :instalment, a.filePath = :filePath " +
                "WHERE a.id = :id")
@NamedQuery(name = "findUserEmail", query = "SELECT a FROM AdminRegistractionEntity a WHERE a.email = :SetEmail")
@NamedQuery(name = "resetByEmail", query = "SELECT a FROM AdminRegistractionEntity a WHERE a.email = :SetEmail")
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

    @Column(name = "ImageFilePath")
    private String filePath;

    @Column(name = "loginCount")
    private int LoginCount;

    @Column(name="lockTime")
    LocalDateTime accountLockTime;

   // @Column(name="isLocked")
   // private boolean isLocked;


}
