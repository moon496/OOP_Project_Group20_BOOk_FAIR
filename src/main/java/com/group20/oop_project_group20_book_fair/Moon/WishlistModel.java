package com.group20.oop_project_group20_book_fair.Moon;

import java.util.ArrayList;
import java.util.List;

public class WishlistModel {
    String title;
    String author;
    String category;
    String price;

    public WishlistModel(String title, String author , String category , String price){
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public class WishlistManager {

        private static List<String> wishlist = new ArrayList<>();

        public static void addToWishlist(String bookName) {
            if (!wishlist.contains(bookName)) {
                wishlist.add(bookName);
            }
        }

        public static boolean isInWishlist(String bookName) {
            return wishlist.contains(bookName);
        }

        public static List<String> getWishlist() {
            return wishlist;
        }
    }
    @Override
    public String toString() {
        return "WishlistModel{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
