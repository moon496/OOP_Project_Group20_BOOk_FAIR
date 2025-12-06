package com.group20.oop_project_group20_book_fair.Ataur;

import java.time.LocalDate;

public class StallManagerDayReport {
    private int totalsaleboooks, outofstockbooks, mostsellingbooks;
    private LocalDate datelocal;

    public StallManagerDayReport(int totalsaleboooks, int outofstockbooks, int mostsellingbooks, LocalDate datelocal) {
        this.totalsaleboooks = totalsaleboooks;
        this.outofstockbooks = outofstockbooks;
        this.mostsellingbooks = mostsellingbooks;
        this.datelocal = datelocal;
    }

    public int getTotalsaleboooks() {
        return totalsaleboooks;
    }

    public void setTotalsaleboooks(int totalsaleboooks) {
        this.totalsaleboooks = totalsaleboooks;
    }

    public int getOutofstockbooks() {
        return outofstockbooks;
    }

    public void setOutofstockbooks(int outofstockbooks) {
        this.outofstockbooks = outofstockbooks;
    }

    public int getMostsellingbooks() {
        return mostsellingbooks;
    }

    public void setMostsellingbooks(int mostsellingbooks) {
        this.mostsellingbooks = mostsellingbooks;
    }

    public LocalDate getDatelocal() {
        return datelocal;
    }

    public void setDatelocal(LocalDate datelocal) {
        this.datelocal = datelocal;
    }

    @Override
    public String toString() {
        return "StallManagerDayReport{" +
                "totalsaleboooks=" + totalsaleboooks +
                ", outofstockbooks=" + outofstockbooks +
                ", mostsellingbooks=" + mostsellingbooks +
                ", datelocal=" + datelocal +
                '}';
    }
}
