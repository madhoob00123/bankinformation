package com.abcbankinfo.bankapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class BankInfo {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("balance")
    private double balance;

//    public BankInfo(double balance){
//        this.balance=balance;
//    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "id :"+ id +"Balance:"+balance;
    }
}
