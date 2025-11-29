package com.group20.oop_project_group20_book_fair.Moon;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {
    private final StringProperty book = new SimpleStringProperty();
    private final StringProperty author = new SimpleStringProperty();
    private final DoubleProperty price = new SimpleDoubleProperty();

    public Book(String book, String author, double price) {
        this.book.set(book);
        this.author.set(author);
        this.price.set(price);
    }

    public StringProperty bookProperty() { return book; }
    public StringProperty authorProperty() { return author; }
    public DoubleProperty priceProperty() { return price; }
}
