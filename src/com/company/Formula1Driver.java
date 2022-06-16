package com.company;

import java.util.Collections;
import java.util.Scanner;
public class Formula1Driver extends Driver implements Comparable<Formula1Driver> {


        private int noOfFirstPositions;
        private int noOfSecondPositions;
        private int noOfThirdPositions;
        private int noOfPoints;
        private int noOfRaces;

        //Creating constructor
        public Formula1Driver(String name, String location, String team, int firstPositions, int secondPositions, int thirdPositions, int points, int races) {
            super(name, location, team);
            this.noOfFirstPositions = firstPositions;
            this.noOfSecondPositions = secondPositions;
            this.noOfThirdPositions = thirdPositions;
            this.noOfPoints = points;
            this.noOfRaces = races;

        }

        public int getNoOfFirstPositions() {
            return noOfFirstPositions;
        }

        public void setNoOfFirstPositions(int noOfFirstPositions) {
            this.noOfFirstPositions = noOfFirstPositions;
        }

        public int getNoOfSecondPositions() {
            return noOfSecondPositions;
        }

        public void setNoOfSecondPositions(int noOfSecondPositions) {
            this.noOfSecondPositions = noOfSecondPositions;
        }

        public int getNoOfThirdPositions() {
            return noOfThirdPositions;
        }

        public void setNoOfThirdPositions(int noOfThirdPositions) {
            this.noOfThirdPositions = noOfThirdPositions;
        }

        public int getNoOfPoints() {
            return noOfPoints;
        }

        public void setNoOfPoints(int noOfPoints) {
            this.noOfPoints = noOfPoints;
        }

        public int getNoOfRaces() {
            return noOfRaces;
        }

        public void setNoOfRaces(int noOfRaces) {
            this.noOfRaces = noOfRaces;
        }

        public String toString() {
            return getDriverName()+" "+getDriverLocation()+" "+getDriverTeam()+" "+getNoOfFirstPositions()+" "+getNoOfFirstPositions()+" "+getNoOfSecondPositions()+" "+getNoOfThirdPositions()+" "+getNoOfPoints()+" "+getNoOfRaces();

        }
        //Method to add the points accoding to the positions achieved
        public void addCompleteRace() {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter the position achieved by the driver");
            int position = Integer.parseInt(myObj.nextLine());
            if (position == 1) {
                noOfFirstPositions++;
                noOfPoints += 25;
            } else if (position == 2) {
                noOfSecondPositions++;
                noOfPoints += 18;
            } else if (position == 3) {
                noOfThirdPositions++;
                noOfPoints += 15;
            } else if (position == 4) {
                noOfPoints += 12;
            } else if (position == 5) {
                noOfPoints += 10;
            } else if (position == 6) {
                noOfPoints += 8;
            } else if (position == 7) {
                noOfPoints += 6;
            } else if (position == 8) {
                noOfPoints += 4;
            } else if (position == 9) {
                noOfPoints = 2;
            } else if (position == 10) {
                noOfPoints += 1;
            }
            noOfRaces++;
        }


    static int x =-1;
    static int y = 1;
    static int z= 0;

    //Sorting methods
    public static void ascending(){
        x=1;
        y=-1;
        Collections.sort(Formula1ChampionshipManager.DriverList);
        x=-1;
        y=1;


    }
    public static void descending() {

        Collections.sort(Formula1ChampionshipManager.DriverList);
    }
    public static void firstPositions(){
        z=1;
        Collections.sort(Formula1ChampionshipManager.DriverList);
        z=0;


    }





    @Override
        public int compareTo(Formula1Driver o) {
            if (z == 0) {
                if (noOfPoints == o.noOfPoints) {
                    if (noOfFirstPositions > o.noOfSecondPositions) {
                        return x;
                    } else if (noOfFirstPositions < o.noOfFirstPositions) {
                        return y;
                    } else {
                        return 0;
                    }
                } else if (noOfPoints > o.noOfPoints) {
                    return x;
                } else return y;
            }
            else {
                if (noOfFirstPositions==o.noOfFirstPositions){
                    return 0;
                }
                else if (noOfFirstPositions>o.noOfFirstPositions){
                    return x;
                }
                else {
                    return y;
                }
            }

        }

    }
















    





