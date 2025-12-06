package com.group20.oop_project_group20_book_fair.Ataur;

public class ViewInventory {
        private String bookName;
        private String author;
        private String category;

    public ViewInventory(String bookName, String author, String category) {
        this.bookName = bookName;
        this.author = author;
        this.category = category;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ViewInventory{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}



