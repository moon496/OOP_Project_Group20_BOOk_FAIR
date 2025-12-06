package com.group20.oop_project_group20_book_fair.Ataur;

import javafx.beans.property.*;

public class BookInventory {

    private final StringProperty bookName;
    private final StringProperty author;
    private final StringProperty category;
    private final IntegerProperty stock;

    public BookInventory(String bookName, String author, String category, int stock) {
        this.bookName = new SimpleStringProperty(bookName);
        this.author = new SimpleStringProperty(author);
        this.category = new SimpleStringProperty(category);
        this.stock = new SimpleIntegerProperty(stock);
    }

    // Getters + Properties
    public String getBookName() {
        return bookName.get();
    }
    public StringProperty bookNameProperty() {
        return bookName;
    }

    public String getAuthor() {
        return author.get();
    }
    public StringProperty authorProperty() {
        return author;
    }

    public String getCategory() {
        return category.get();
    }
    public StringProperty categoryProperty() {
        return category;
    }

    public int getStock() {
        return stock.get();
    }
    public IntegerProperty stockProperty() {
        return stock;
    }
}
