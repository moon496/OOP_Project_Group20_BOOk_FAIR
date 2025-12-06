package com.group20.oop_project_group20_book_fair.Moon;

import java.time.LocalDate;

public class Promotion {
    private String name;
    private String book;
    private double discount;
    private LocalDate startDate;
    private LocalDate endDate;
    public Promotion(String name, String book, double discount, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.book = book;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
