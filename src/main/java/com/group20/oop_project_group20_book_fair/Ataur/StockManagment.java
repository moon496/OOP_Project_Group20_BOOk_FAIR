package com.group20.oop_project_group20_book_fair.Ataur;

public class StockManagment {
    private String bookname,customername,mobilenumber;

    public StockManagment(String bookname, String customername, String mobilenumber) {
        this.bookname = bookname;
        this.customername = customername;
        this.mobilenumber = mobilenumber;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Override
    public String toString() {
        return "StockManagment{" +
                "bookname='" + bookname + '\'' +
                ", customername='" + customername + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                '}';
    }
}
