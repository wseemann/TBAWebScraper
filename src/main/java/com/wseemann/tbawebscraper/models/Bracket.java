package com.wseemann.tbawebscraper.models;

public class Bracket {

    private String name;
    private String bracketClass;
    private double lowerWeight = 0;
    private double upperWeight = 500.0;

    public Bracket() {

    }

    public Bracket(String name, String bracketClass, double lowerWeight, double upperWeight) {
        this.name = name;
        this.bracketClass = bracketClass;
        this.lowerWeight = lowerWeight;
        this.upperWeight = upperWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBracketClass() {
        return bracketClass;
    }

    public void setBracketClass(String bracketClass) {
        this.bracketClass = bracketClass;
    }

    public double getLowerWeight() {
        return lowerWeight;
    }

    public void setLowerWeight(double lowerWeight) {
        this.lowerWeight = lowerWeight;
    }

    public double getUpperWeight() {
        return upperWeight;
    }

    public void setUpperWeight(double upperWeight) {
        this.upperWeight = upperWeight;
    }

    @Override
    public String toString() {
        return "Name: " + name + " " +
                "Lower Weight: " + lowerWeight + " " +
                "Upper Weight: " + upperWeight;
    }
}
