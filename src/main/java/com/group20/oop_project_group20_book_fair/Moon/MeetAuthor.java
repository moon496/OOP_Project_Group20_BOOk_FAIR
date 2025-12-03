package com.group20.oop_project_group20_book_fair.Moon;

public class MeetAuthor {
    private String authorName;
    private String eventName;
    private String time;
    private String venue;


    public MeetAuthor(String authorName, String eventName, String time, String venue) {
        this.authorName = authorName;
        this.eventName = eventName;
        this.time = time;
        this.venue = venue;
}

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

    @Override
    public String toString() {
        return "MeetAuthor{" +
                "authorName='" + authorName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", time='" + time + '\'' +
                ", venue='" + venue + '\'' +
                '}';
    }
}
