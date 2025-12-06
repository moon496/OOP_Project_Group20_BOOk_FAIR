package com.group20.oop_project_group20_book_fair.Ataur;

import java.time.LocalDate;

public class Emergency {
    private String textfield,labelshwo, cbox;
    private LocalDate dateshwo;

    public Emergency(String textfield, String labelshwo, String cbox, LocalDate dateshwo) {
        this.textfield = textfield;
        this.labelshwo = labelshwo;
        this.cbox = cbox;
        this.dateshwo = dateshwo;
    }

    public String getTextfield() {
        return textfield;
    }

    public void setTextfield(String textfield) {
        this.textfield = textfield;
    }

    public String getLabelshwo() {
        return labelshwo;
    }

    public void setLabelshwo(String labelshwo) {
        this.labelshwo = labelshwo;
    }

    public String getCbox() {
        return cbox;
    }

    public void setCbox(String cbox) {
        this.cbox = cbox;
    }

    public LocalDate getDateshwo() {
        return dateshwo;
    }

    public void setDateshwo(LocalDate dateshwo) {
        this.dateshwo = dateshwo;
    }

    @Override
    public String toString() {
        return "Emergency{" +
                "textfield='" + textfield + '\'' +
                ", labelshwo='" + labelshwo + '\'' +
                ", cbox='" + cbox + '\'' +
                ", dateshwo=" + dateshwo +
                '}';
    }
}
