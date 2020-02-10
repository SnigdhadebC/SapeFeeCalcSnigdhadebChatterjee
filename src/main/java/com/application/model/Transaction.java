package com.application.model;

import java.util.Date;

public class Transaction {
    private String externalTransactionId;
    private String clientId;
    private String SecurityId;
    private String transactionType;
    private Date transactionDate;
    private double marketValue;
    private double processingFee;
    private char priority;
    private boolean isIntraDayTransaction;

    public Transaction() {
    }

    public Transaction(String externalTransactionId, String clientId, String securityId, String transactionType, Date transactionDate, double marketValue,char priority) {
        this.externalTransactionId = externalTransactionId;
        this.clientId = clientId;
        SecurityId = securityId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.marketValue = marketValue;
        this.priority = priority;
    }

    public String getExternalTransactionId() {
        return externalTransactionId;
    }

    public void setExternalTransactionId(String externalTransactionId) {
        this.externalTransactionId = externalTransactionId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecurityId() {
        return SecurityId;
    }

    public void setSecurityId(String securityId) {
        SecurityId = securityId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public char getPriority() {
        return priority;
    }

    public void setPriority(char priority) {
        this.priority = priority;
    }

    public boolean isIntraDayTransaction() {
        return isIntraDayTransaction;
    }

    public void setIntraDayTransaction(boolean intraDayTransaction) {
        isIntraDayTransaction = intraDayTransaction;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "externalTransactionId='" + externalTransactionId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", SecurityId='" + SecurityId + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate=" + transactionDate +
                ", marketValue=" + marketValue +
                ", isIntraDayTransaction=" + isIntraDayTransaction +
                ", processingFee=" + processingFee +
                ", priority=" + priority +
                '}';
    }
}
