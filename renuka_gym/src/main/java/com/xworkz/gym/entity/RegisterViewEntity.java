package com.xworkz.gym.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name="reg_history")

//@NamedQuery(name = "getRegHistory", query = "SELECT e FROM RegisterViewEntity e")
@NamedQuery(name = "getRegHistoryById", query = "select ls from RegisterViewEntity ls where ls.registerId = :Setid")


public class RegisterViewEntity  extends AbstractAductEntity {


    @Id
    private int id;
    @Column(name="reg_id")
    private int registerId;
    @Column(name="packaged")
    private String packaged;
    @Column(name="name")
    private String name;
    @Column(name="trainer")
    private String trainer;
    @Column(name="instalment")
    private String instalment;
    @Column(name="amount")
    private double amount;
    @Column(name="balance")
    private double balance;

}
