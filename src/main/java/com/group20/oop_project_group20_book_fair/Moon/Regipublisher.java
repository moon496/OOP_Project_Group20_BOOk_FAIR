package com.group20.oop_project_group20_book_fair.Moon;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Regipublisher {

    private final SimpleStringProperty publisherName;
    private final SimpleStringProperty contact;
    private final SimpleStringProperty address;


    public Regipublisher(String name, String address, String contact) {
        this.publisherName = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.contact = new SimpleStringProperty(contact);
    }


    public StringProperty publisherNameProperty() {
        return publisherName;
    }

    public StringProperty addressProperty() {
        return address;
    }

    public StringProperty contactProperty() {
        return contact;
    }

    public String getPublisherName() {
        return publisherName.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getContact() {
        return contact.get();
    }

    public void setPublisherName(String name) {
        this.publisherName.set(name);
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }
}