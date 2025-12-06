package com.group20.oop_project_group20_book_fair.Toriqul;

public class StallInfo {

    private String stallNo;
    private String stallName;
    private String ownerName;

    public StallInfo(String stallNo, String stallName, String ownerName) {
        this.stallNo = stallNo;
        this.stallName = stallName;
        this.ownerName = ownerName;
    }

    public String getStallNo() { return stallNo; }
    public String getStallName() { return stallName; }
    public String getOwnerName() { return ownerName; }

    public void setStallNo(String stallNo) { this.stallNo = stallNo; }
    public void setStallName(String stallName) { this.stallName = stallName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
}
