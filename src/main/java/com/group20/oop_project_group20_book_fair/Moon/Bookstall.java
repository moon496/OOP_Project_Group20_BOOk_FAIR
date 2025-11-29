package com.group20.oop_project_group20_book_fair.Moon;

public class Bookstall {
    private String name;
    private String category;

   
    public Bookstall(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Bookstall{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}