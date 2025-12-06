package com.group20.oop_project_group20_book_fair.Moon;

public class MeetAuthor {
    private String authorName;
    private String eventName;
    private String date;
    private String time;
    private String venue;
    private String seats;

    // 6 parameter constructor
    public MeetAuthor(String authorName, String eventName, String date, String time, String venue, String seats) {
        this.authorName = authorName;
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.venue = venue;
        this.seats = seats;
    }


    // Getters and Setters
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "MeetAuthor{" +
                "authorName='" + authorName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", venue='" + venue + '\'' +
                ", seats='" + seats + '\'' +
                '}';
    }
}