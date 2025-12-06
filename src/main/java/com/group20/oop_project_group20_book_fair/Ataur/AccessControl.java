package com.group20.oop_project_group20_book_fair.Ataur;

public class AccessControl {
    private String personName;
    private String accessLevel;
    private String entryLabel;

    public AccessControl(String personName, String accessLevel, String entryLabel) {
        this.personName = personName;
        this.accessLevel = accessLevel;
        this.entryLabel = entryLabel;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getEntryLabel() {
        return entryLabel;
    }

    public void setEntryLabel(String entryLabel) {
        this.entryLabel = entryLabel;
    }

    @Override
    public String toString() {
        return "AccessControl{" +
                "personName='" + personName + '\'' +
                ", accessLevel='" + accessLevel + '\'' +
                ", entryLabel='" + entryLabel + '\'' +
                '}';
    }
}
