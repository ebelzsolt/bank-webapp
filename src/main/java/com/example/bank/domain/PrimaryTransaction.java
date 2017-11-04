package com.example.bank.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PrimaryTransaction {

    private Long id;
    private Date date;
    private String descriptrion;
    private String type;
    private String status;
    private double amount;
    private BigDecimal availableBalance;
    private PrimaryAccount primaryAccount;

    public PrimaryTransaction() {

    }

    public PrimaryTransaction(Date date, String descriptrion, String type, String status, double amount, BigDecimal availableBalance,
            PrimaryAccount primaryAccount) {
        super();
        this.date = date;
        this.descriptrion = descriptrion;
        this.type = type;
        this.status = status;
        this.amount = amount;
        this.availableBalance = availableBalance;
        this.primaryAccount = primaryAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescriptrion() {
        return descriptrion;
    }

    public void setDescriptrion(String descriptrion) {
        this.descriptrion = descriptrion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public PrimaryAccount getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(PrimaryAccount primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

}
