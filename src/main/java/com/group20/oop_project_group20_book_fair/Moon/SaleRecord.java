package com.group20.oop_project_group20_book_fair.Moon;

import javafx.beans.property.*;

public class SaleRecord {
    private final StringProperty bookName;
    private final StringProperty category;
    private final IntegerProperty quantity;
    private final DoubleProperty saleAmount;
    private final StringProperty date;

    public SaleRecord(String bookName, String category, int quantity, double saleAmount, String date) {
        this.bookName = new SimpleStringProperty(bookName);
        this.category = new SimpleStringProperty(category);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.saleAmount = new SimpleDoubleProperty(saleAmount);
        this.date = new SimpleStringProperty(date);
    }
    public StringProperty bookNameProperty() { return bookName; }
    public String getBookName() { return bookName.get(); }

    public StringProperty categoryProperty() { return category; }
    public String getCategory() { return category.get(); }

    public IntegerProperty quantityProperty() { return quantity; }
    public int getQuantity() { return quantity.get(); }

    public DoubleProperty saleAmountProperty() { return saleAmount; }
    public double getSaleAmount() { return saleAmount.get(); }

    public StringProperty dateProperty() { return date; }
    public String getDate() { return date.get(); }
}

