package com.group20.oop_project_group20_book_fair.Toriqul;

public class ServiceRecord {

    private String serviceName;
    private int customerCount;

    public ServiceRecord(String serviceName, int customerCount) {
        this.serviceName = serviceName;
        this.customerCount = customerCount;
    }

    public String getServiceName() { return serviceName; }
    public int getCustomerCount() { return customerCount; }

    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public void setCustomerCount(int customerCount) { this.customerCount = customerCount; }
}
