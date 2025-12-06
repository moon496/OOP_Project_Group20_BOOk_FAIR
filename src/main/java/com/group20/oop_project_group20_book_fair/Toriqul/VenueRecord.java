package com.group20.oop_project_group20_book_fair.Toriqul;

public class VenueRecord {

    private String id;
    private String name;
    private String eventType;
    private String location;
    private int capacity;

    public VenueRecord(String id, String name,
                       String eventType, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.eventType = eventType;
        this.location = location;
        this.capacity = capacity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEventType() { return eventType; }
    public String getLocation() { return location; }
    public int getCapacity() { return capacity; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setLocation(String location) { this.location = location; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
