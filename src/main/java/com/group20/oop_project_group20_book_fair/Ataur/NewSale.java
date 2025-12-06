package com.group20.oop_project_group20_book_fair.Ataur;

public class NewSale {
    private int qunantity;
    private String selectBooks;

    public NewSale(int qunantity, String selectBooks) {
        this.qunantity = qunantity;
        this.selectBooks = selectBooks;
    }

    public int getQunantity() {
        return qunantity;
    }

    public void setQunantity(int qunantity) {
        this.qunantity = qunantity;
    }

    public String getSelectBooks() {
        return selectBooks;
    }

    public void setSelectBooks(String selectBooks) {
        this.selectBooks = selectBooks;
    }

    @Override
    public String toString() {
        return "NewSale{" +
                "qunantity=" + qunantity +
                ", selectBooks='" + selectBooks + '\'' +
                '}';
    }
}
