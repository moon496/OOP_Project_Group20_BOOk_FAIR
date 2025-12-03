package com.group20.oop_project_group20_book_fair.Moon;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.value.ObservableValue;

public class SeminarEvent {
   String name;
   String date;
    String time;
    int seats;
    String type;

    public SeminarEvent(String name,String date,String time,int seats,String type){
        this.name = name;
        this.date = date;
        this.time = time;
        this.seats = seats;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public ObservableValue<String> date() {
        return null;
    }
}
