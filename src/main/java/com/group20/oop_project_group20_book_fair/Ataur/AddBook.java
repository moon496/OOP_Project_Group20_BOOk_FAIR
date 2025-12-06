package com.group20.oop_project_group20_book_fair.Ataur;

public class AddBook {
    private String bookname, addauthorname, addprice, showinputdata, bookcatagorycb;

    public AddBook(String bookname, String addauthorname, String addprice, String showinputdata, String bookcatagorycb) {
        this.bookname = bookname;
        this.addauthorname = addauthorname;
        this.addprice = addprice;
        this.showinputdata = showinputdata;
        this.bookcatagorycb = bookcatagorycb;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAddauthorname() {
        return addauthorname;
    }

    public void setAddauthorname(String addauthorname) {
        this.addauthorname = addauthorname;
    }

    public String getAddprice() {
        return addprice;
    }

    public void setAddprice(String addprice) {
        this.addprice = addprice;
    }

    public String getShowinputdata() {
        return showinputdata;
    }

    public void setShowinputdata(String showinputdata) {
        this.showinputdata = showinputdata;
    }

    public String getBookcatagorycb() {
        return bookcatagorycb;
    }

    public void setBookcatagorycb(String bookcatagorycb) {
        this.bookcatagorycb = bookcatagorycb;
    }

    @Override
    public String toString() {
        return "AddBook{" +
                "bookname='" + bookname + '\'' +
                ", addauthorname='" + addauthorname + '\'' +
                ", addprice='" + addprice + '\'' +
                ", showinputdata='" + showinputdata + '\'' +
                ", bookcatagorycb='" + bookcatagorycb + '\'' +
                '}';
    }
}
