package com.group20.oop_project_group20_book_fair.Moon;

import java.time.LocalDateTime;

public class SecurityComplain {
     String complaintId;
     String issueType;
     String location;
     String details;
     String recipient;
     String urgency;
     LocalDateTime timestamp;
     String status;
     String resolvedBy;
     LocalDateTime resolvedTime;
     String resolution;

    public  SecurityComplain(String complaintId, String issueType, String location, String details, String recipient, String urgency,LocalDateTime timestamp, String status) {
        this.complaintId = complaintId;
        this.issueType = issueType;
        this.location = location;
        this.details = details;
        this.recipient = recipient;
        this.urgency = urgency;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public LocalDateTime getResolvedTime() {
        return resolvedTime;
    }

    public void setResolvedTime(LocalDateTime resolvedTime) {
        this.resolvedTime = resolvedTime;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "SecurityComplain{" +
                "complaintId='" + complaintId + '\'' +
                ", issueType='" + issueType + '\'' +
                ", location='" + location + '\'' +
                ", details='" + details + '\'' +
                ", recipient='" + recipient + '\'' +
                ", urgency='" + urgency + '\'' +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                ", resolvedBy='" + resolvedBy + '\'' +
                ", resolvedTime=" + resolvedTime +
                ", resolution='" + resolution + '\'' +
                '}';
    }
    private boolean validateInputs() {
        return false;
    }
}
