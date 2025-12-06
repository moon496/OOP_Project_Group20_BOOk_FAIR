package com.group20.oop_project_group20_book_fair.Toriqul;

public class PaymentRecord {

    private String stallName;
    private double amount;
    private String date;

    public PaymentRecord(String stallName, double amount, String date) {
        this.stallName = stallName;
        this.amount = amount;
        this.date = date;
    }

    public String getStallName() { return stallName; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }

    public void setStallName(String stallName) { this.stallName = stallName; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDate(String date) { this.date = date; }
}
