package com.group20.oop_project_group20_book_fair.Toriqul;

public class StallRegistration {

    private String id;
    private String ownerName;
    private String stallName;
    private String contact;
    private String status; // PENDING / APPROVED / REJECTED

    public StallRegistration(String id, String ownerName,
                             String stallName, String contact, String status) {
        this.id = id;
        this.ownerName = ownerName;
        this.stallName = stallName;
        this.contact = contact;
        this.status = status;
    }

    public String getId() { return id; }
    public String getOwnerName() { return ownerName; }
    public String getStallName() { return stallName; }
    public String getContact() { return contact; }
    public String getStatus() { return status; }

    public void setId(String id) { this.id = id; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setStallName(String stallName) { this.stallName = stallName; }
    public void setContact(String contact) { this.contact = contact; }
    public void setStatus(String status) { this.status = status; }
}
