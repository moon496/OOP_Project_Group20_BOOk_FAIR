package com.group20.oop_project_group20_book_fair.Ataur;

import java.time.LocalDate;

public class SalesReport {
    private LocalDate date;
    private int totalsale;
    private String labelText;

    public SalesReport(LocalDate date, int totalsale, String labelText) {
        this.date = date;
        this.totalsale = totalsale;
        this.labelText = labelText;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalsale() {
        return totalsale;
    }

    public void setTotalsale(int totalsale) {
        this.totalsale = totalsale;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    @Override
    public String toString() {
        return "SalesReport{" +
                "date=" + date +
                ", totalsale=" + totalsale +
                ", labelText='" + labelText + '\'' +
                '}';
    }
}
