package com.company;

 abstract class Driver {
    private String driverName;
    private String driverLocation;
    private String driverTeam;


    //Creating constructor
    public Driver(String name,String location,String team) {
        this.driverName=name;
        this.driverLocation=location;
        this.driverTeam=team;
    }


     //Creating getters and setters
     public String getDriverName() {
        return driverName;
    }

     public void setDriverName(String driverName) {
         this.driverName = driverName;
     }

     public String getDriverLocation() {
         return driverLocation;
     }

     public void setDriverLocation(String driverLocation) {
         this.driverLocation = driverLocation;
     }

     public String getDriverTeam() {
         return driverTeam;
     }

     public void setDriverTeam(String driverTeam) {
         this.driverTeam = driverTeam;
     }

     public  abstract void  setNoOfFirstPositions(int noOfFirstPositions);
     public  abstract void  setNoOfSecondPositions(int noOfSecondPositions);
     public  abstract void  setNoOfThirdPositions(int noOfThirdPositions);

     public  abstract void  setNoOfPoints(int noOfPoints);
     public abstract void setNoOfRaces(int noOfRaces);


     public abstract void addCompleteRace();
 }















