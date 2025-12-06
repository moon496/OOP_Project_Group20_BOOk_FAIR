package com.group20.oop_project_group20_book_fair.Ataur;

import java.time.LocalDate;

public class LostFound {
    private String name,details,productname,visitorname;
    private int mobilenumber;
    private LocalDate dateshow;

    public LostFound(String name, String details, String productname, String visitorname, int mobilenumber, LocalDate dateshow) {
        this.name = name;
        this.details = details;
        this.productname = productname;
        this.visitorname = visitorname;
        this.mobilenumber = mobilenumber;
        this.dateshow = dateshow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getVisitorname() {
        return visitorname;
    }

    public void setVisitorname(String visitorname) {
        this.visitorname = visitorname;
    }

    public int getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(int mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public LocalDate getDateshow() {
        return dateshow;
    }

    public void setDateshow(LocalDate dateshow) {
        this.dateshow = dateshow;
    }

    @Override
    public String toString() {
        return "LostFound{" +
                "name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", productname='" + productname + '\'' +
                ", visitorname='" + visitorname + '\'' +
                ", mobilenumber=" + mobilenumber +
                ", dateshow=" + dateshow +
                '}';
    }
}
