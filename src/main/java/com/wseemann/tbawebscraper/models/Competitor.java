package com.wseemann.tbawebscraper.models;

public class Competitor {

    private String firstName;
    private String lastName;
    private String stats;
    private String record;
    private String gymName;

    public Competitor() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + " " +
                "Last Name: " + lastName + " " +
                "Stats: " + stats + " " +
                "Record: " + record + " " +
                "Gym Name: " + gymName;
    }
}
