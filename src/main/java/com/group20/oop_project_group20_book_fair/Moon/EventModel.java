package com.group20.oop_project_group20_book_fair.Moon;

public class EventModel {

    private String name;
    private String date;
    private String time;
    private String venue;

    private int seats;

    public EventModel(String name, String date, String time, String venue, String type, int seats) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.venue = venue;

        this.seats = seats;
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }



    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
