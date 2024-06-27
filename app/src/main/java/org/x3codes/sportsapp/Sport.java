package org.x3codes.sportsapp;

public class Sport {
    private final String sportName;
    private final int sportImg;

    public Sport(String sportName, int sportImg) {
        this.sportName = sportName;
        this.sportImg = sportImg;
    }

    public String getSportName() {
        return sportName;
    }

    public int getSportImg() {
        return sportImg;
    }
}
