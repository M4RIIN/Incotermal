package org.example.domain.entity;

public class CoutEtape {
    private final String description;
    private double cout;

    public CoutEtape(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }
}
