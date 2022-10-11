package com.example.Challenges2.dao;

import java.sql.Date;

public class AccountDao {
    private int id;
    private String accType;
    private String accNumber;
    private String accName;
    private int balance;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", accType='" + accType + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", accName='" + accName + '\'' +
                ", balance=" + balance +
                ", date=" + date +
                '}';
    }
}