package org.example;


import java.io.BufferedReader;

class Athlete{
    String athleteNumber;
    String athleteName;
    String countryCode;
     String skiTimeResult;
     String firstShootingRange;
     String secondShooting;
     String thirdShooting;
     String finalTime;

     int totalTimeInSeconds;
     int secondsPenality;

    public int getSecondsPenality() {
        return secondsPenality;
    }

    public void setSecondsPenality(int secondsPenality) {
        this.secondsPenality = secondsPenality;
    }

    public int getTotalTimeInSeconds() {
        return totalTimeInSeconds;
    }

    public void setTotalTimeInSeconds(int totalTimeInSeconds) {
        this.totalTimeInSeconds = totalTimeInSeconds;
    }

    public Athlete() {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShooting = secondShooting;
        this.thirdShooting = thirdShooting;
    }



    public void setAthleteNumber(String athleteNumber) {
        this.athleteNumber = athleteNumber;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setSkiTimeResult(String skiTimeResult) {
        this.skiTimeResult = skiTimeResult;
    }

    public void setFirstShootingRange(String firstShootingRange) {
        this.firstShootingRange = firstShootingRange;
    }

    public void setSecondShooting(String secondShooting) {
        this.secondShooting = secondShooting;
    }

    public void setThirdShooting(String thirdShooting) {
        this.thirdShooting = thirdShooting;
    }
    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    public String getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public  String getSkiTimeResult() {
        return skiTimeResult;
    }

    public  String getFirstShootingRange() {
        return firstShootingRange;
    }

    public String getSecondShooting() {
        return secondShooting;
    }

    public String getFinalTime() {
        return finalTime;
    }

    public  String getThirdShooting() {
        return thirdShooting;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "athleteNumber='" + athleteNumber + '\'' +
                ", athleteName='" + athleteName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult='" + skiTimeResult + '\'' +
                ", firstShootingRange='" + firstShootingRange + '\'' +
                ", secondShooting='" + secondShooting + '\'' +
                ", thirdShooting='" + thirdShooting + '\'' +
                '}';
    }

}
