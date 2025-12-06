package com.group20.oop_project_group20_book_fair.Toriqul;

public class LayoutAssignment {

    private String stallName;
    private String location;

    public LayoutAssignment(String stallName, String location) {
        this.stallName = stallName;
        this.location = location;
    }

    public String getStallName() { return stallName; }
    public String getLocation() { return location; }

    public void setStallName(String stallName) { this.stallName = stallName; }
    public void setLocation(String location) { this.location = location; }
}
