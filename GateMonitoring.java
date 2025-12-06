package com.group20.oop_project_group20_book_fair.Ataur;

public class GateMonitoring {

    private String name,status,action;
    private int count,capacity;

    public GateMonitoring(String name, String status, String action, int count, int capacity) {
        this.name = name;
        this.status = status;
        this.action = action;
        this.count = count;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "GateMonitoring{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", action='" + action + '\'' +
                ", count=" + count +
                ", capacity=" + capacity +
                '}';
    }
}
