package com.group20.oop_project_group20_book_fair.Ataur;

public class DiscountsCorner {
    private String bookname;
    private double discountPercentage;
    private double discountPrice;

    public DiscountsCorner(String bookname, double discountPercentage, double discountPrice) {
        this.bookname = bookname;
        this.discountPercentage = discountPercentage;
        this.discountPrice = discountPrice;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "DiscountsCorner{" +
                "bookname='" + bookname + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
