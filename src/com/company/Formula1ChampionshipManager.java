package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager{
    static ArrayList<Formula1Driver> DriverList = new ArrayList<Formula1Driver>();  //Creating an arraylist

    public static void main(String[] args) throws IOException {

        Formula1ChampionshipManager F1 = new Formula1ChampionshipManager();
        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.println("****************************************");
            System.out.println("1: Add a new driver");
            System.out.println("2: Delete a driver");
            System.out.println("3: Change the driver for an existing constructor team ");
            System.out.println("4: Display various statistics for selected existing driver");
            System.out.println("5: Display Formula1 Driver Table ");
            System.out.println("6: Add a race completed with its date and the positions that all the drivers achieved.");
            System.out.println("7: Save all information to a file");
            System.out.println("8: Read all information saved");
            System.out.println("9: Open the gui");
            System.out.println("10: Exit the program");
            System.out.println("******************************************");
            System.out.println("Enter your option:");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    F1.addDriver();
                    break;
                case 2:
                    F1.deleteDriver();
                    break;
                case 3:
                    F1.changeDriver();
                    break;
                case 4:
                    F1.showStatistics();
                    break;
                case 5:
                    F1.driverTable();
                    break;
                case 6:
                    F1.addRace();
                    break;
                case 7:
                    F1.saveFile();
                    break;
                case 8:
                    F1.LoadFromFile();
                    break;
                case 9:
                    F1.GUI();
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Incorrect Input. Try again");
                    break;
            }
        }

    }

    //Method to add a new driver and their information
    public  void addDriver() {


        Scanner obj1 = new Scanner(System.in);
        System.out.println("Enter the name of the driver");
        String dName = obj1.nextLine();
        System.out.println("Enter the location of the driver");
        String dLocation = obj1.nextLine();
        System.out.println("Enter the team of the driver");
        String dTeam = obj1.nextLine();
        System.out.println("Enter the number of first positions achieved by the driver");
        int dFirstPositions = Integer.parseInt(obj1.nextLine());
        int dPoints1=25*dFirstPositions;
        System.out.println("Enter the number of second positions achieved by the driver");
        int dSecondPositions = Integer.parseInt(obj1.nextLine());
        int dPoints2=18*dSecondPositions;
        System.out.println("Enter the number of third positions achieved by the driver");
        int dThirdPositions = Integer.parseInt(obj1.nextLine());
        int dPoints3=15*dThirdPositions;
        int dPoints=dPoints1+dPoints2+dPoints3;

        System.out.println("Enter the number of races participated");
        int dRaces = Integer.parseInt(obj1.nextLine());

        Formula1Driver Race1 = new Formula1Driver(dName, dLocation, dTeam, dFirstPositions, dSecondPositions, dThirdPositions, dPoints, dRaces);
        Race1.setDriverName(dName);
        Race1.setDriverLocation(dLocation);
        Race1.setDriverTeam(dTeam);
        Race1.setNoOfFirstPositions(dFirstPositions);
        Race1.setNoOfSecondPositions(dSecondPositions);
        Race1.setNoOfThirdPositions(dThirdPositions);
        Race1.setNoOfPoints(dPoints);
        Race1.setNoOfRaces(dRaces);


        DriverList.add(Race1);    //Adding data to the arraylist
        System.out.println(dName + " is added");



    }

    //Method to delete a driver
    public void deleteDriver() {
        Scanner obj2 = new Scanner(System.in);
        System.out.println("Enter the name that has to be deleted");
        String name = obj2.nextLine();
        for (int i = 0; i < DriverList.size(); i++) {
            if (DriverList.get(i).getDriverName().equals(name)) {
                DriverList.remove(i);
                System.out.println("Driver is removed");
                break;
            }
        }
    }
     //Method to change a existing driver
    public void changeDriver() {
        Scanner obj3 = new Scanner(System.in);
        System.out.println("Enter the name of the constructor team");
        String Team = obj3.nextLine();
        System.out.println("Enter the new name of the driver");
        String Name = obj3.nextLine();
        for (int i = 0; i < DriverList.size(); i++) {
            if (DriverList.get(i).getDriverTeam().equals(Team)) {
                DriverList.get(i).setDriverName(Name);
                System.out.println("Driver is changed for the selected team");
                break;
            }
        }

    }
    //Method to show the statistics of drivers
    public void showStatistics() {
        Scanner obj4 = new Scanner(System.in);
        System.out.println("Enter the name of the driver");
        String driver = obj4.nextLine();

        for (int i = 0; i < DriverList.size(); i++) {
            if (DriverList.get(i).getDriverName().equals(driver)) {
                System.out.println("Statistics for driver " + DriverList.get(i).getDriverName() + " are given below");
                System.out.println("Number of first positions achieved= " + DriverList.get(i).getNoOfFirstPositions());
                System.out.println("Number of second positions achieved= " + DriverList.get(i).getNoOfSecondPositions());
                System.out.println("Number of third positions achieved= " + DriverList.get(i).getNoOfThirdPositions());
                System.out.println("Number of points achieved= " + DriverList.get(i).getNoOfPoints());
                System.out.println("Number of races participated= " + DriverList.get(i).getNoOfRaces());
                break;
            }
        }
    }

    public void driverTable() {

        Formula1Driver.descending(); //Sorting according to the descending order of points

        System.out.printf("%s%s%s%s%s%s%s%s\n", "Driver name|", "Driver Location|", "Constructor Team|", "Points|", "No of 1st positions|", "No of 2nd positions|", "No of 3rd positions|", "No of races|");

        for (int k = 0; k < DriverList.size(); k++) {

            System.out.printf("%-11s|%-15s|%-16s|%-6s|%-19s|%-19s|%-19s|%-11s\n", DriverList.get(k).getDriverName(), DriverList.get(k).getDriverLocation(), DriverList.get(k).getDriverTeam(), DriverList.get(k).getNoOfPoints(), DriverList.get(k).getNoOfFirstPositions(), DriverList.get(k).getNoOfSecondPositions(), DriverList.get(k).getNoOfThirdPositions(), DriverList.get(k).getNoOfRaces());
        }
    }





    //Method to add new races
    public void addRace(){
        Scanner obj5 = new Scanner(System.in);
        System.out.println("Enter the date of race held");
        String date = obj5.nextLine();
        for(int i=0;i<DriverList.size();i++){
            System.out.println("Add statistics of "+DriverList.get(i).getDriverName());

            DriverList.get(i).addCompleteRace();

        }

        }








    //Method to save all the data into a file
    public  void saveFile() throws IOException {
        File file = new File("Data.txt");  //Creating a file
        FileWriter fw;
        PrintWriter pw;

        fw = new FileWriter(file);
        pw = new PrintWriter(fw,true);

        try {
            for (int j = 0; j < DriverList.size(); j++) {
                pw.println("First name:"+DriverList.get(j).getDriverName()+" "+"Location:"+DriverList.get(j).getDriverLocation()+" "+"Team:"+DriverList.get(j).getDriverTeam()+" "+"Number of first positions:"+DriverList.get(j).getNoOfFirstPositions()+" "+"Number of second positions:"+DriverList.get(j).getNoOfSecondPositions()+" "+"Number of third positions:"+DriverList.get(j).getNoOfThirdPositions()+" "+"Number of points:"+DriverList.get(j).getNoOfPoints()+" "+"Number of Races:"+DriverList.get(j).getNoOfRaces());

            }
            pw.close();
            fw.close();
            System.out.println("Stored data to the file");
        } catch (IOException e) {
            System.out.println("File is not created");
        }
    }
    //Method to load all the saved information in the file
    public void LoadFromFile() {
        System.out.println("File Successfully loaded");
        try {
            File myObj = new File("Data.txt");
            Scanner sc = new Scanner(myObj);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
            }
            sc.close();
        } catch (FileNotFoundException e) {
        }

    }

    //Method to display the gui
    public void GUI(){

        JFrame frame1=new JFrame("Formula1 Championship");  //Creating a frame
        frame1.setSize(400,500);
        frame1.setVisible(true);
        frame1.setLayout(null);
        JLabel label=new JLabel("Formula1 Championship");    //Creating a label
        label.setSize(200,30);
        label.setLocation(100,10);
        frame1.add(label);    //Adding the label to the frame

        JButton btn1=new JButton("Descending");      //Creating a button
        btn1.setSize(108,50);
        btn1.setLocation(50,60);
        frame1.add(btn1);                 //Adding the button to the frame
        JButton btn2=new JButton("Ascending");
        btn2.setSize(100,50);
        btn2.setLocation(200,60);
        frame1.add(btn2);
        JButton btn3=new JButton("First positions");
        btn3.setSize(135,50);
        btn3.setLocation(50,130);
        frame1.add(btn3);
        btn1.addActionListener(new ActionListener(){       //Adding action to the button
           @Override
            public void actionPerformed(ActionEvent e) {
                 JFrame frame2=new JFrame();
                frame2.setSize(400,500);
                frame2.setVisible(true);
                JTable table1=new JTable();

                DefaultTableModel model=new DefaultTableModel();


                JScrollPane scroll;
                String[] columnName={"Name","Location","Team","No of points","No of 1st positions","No of 2nd positions","No of 3rd positions","No of races"};
                model.setColumnIdentifiers(columnName);
                table1.setModel(model);
                scroll=new JScrollPane(table1);

                table1.setBounds(30,40,200,300);

                frame2.add(scroll,BorderLayout.CENTER);
                frame2.setSize(600,600);

                Formula1Driver.descending();      //Calling the sorting method




                for(int j=0;j<DriverList.size();j++){
                    model.addRow(new Object[]{String.valueOf(DriverList.get(j).getDriverName()),String.valueOf(DriverList.get(j).getDriverLocation()),String.valueOf(DriverList.get(j).getDriverTeam()),String.valueOf(DriverList.get(j).getNoOfPoints()),String.valueOf(DriverList.get(j).getNoOfFirstPositions()),String.valueOf(DriverList.get(j).getNoOfSecondPositions()),String.valueOf(DriverList.get(j).getNoOfThirdPositions()),String.valueOf(DriverList.get(j).getNoOfRaces())});

                }
    }
});
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3=new JFrame();
                frame3.setSize(400,500);
                frame3.setVisible(true);
                JTable table2=new JTable();

                DefaultTableModel model=new DefaultTableModel();


                JScrollPane scroll;
                String[] columnName={"Name","Location","Team","No of points","No of 1st positions","No of 2nd positions","No of 3rd positions","No of races"};
                model.setColumnIdentifiers(columnName);
                table2.setModel(model);
                scroll=new JScrollPane(table2);

                table2.setBounds(30,40,200,300);

                frame3.add(scroll,BorderLayout.CENTER);
                frame3.setSize(600,600);


                Formula1Driver.ascending();           //Calling the sorting method

                for(int j=0;j<DriverList.size();j++){
                    model.addRow(new Object[]{String.valueOf(DriverList.get(j).getDriverName()),String.valueOf(DriverList.get(j).getDriverLocation()),String.valueOf(DriverList.get(j).getDriverTeam()),String.valueOf(DriverList.get(j).getNoOfPoints()),String.valueOf(DriverList.get(j).getNoOfFirstPositions()),String.valueOf(DriverList.get(j).getNoOfSecondPositions()),String.valueOf(DriverList.get(j).getNoOfThirdPositions()),String.valueOf(DriverList.get(j).getNoOfRaces())});

                }

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4=new JFrame();
                frame4.setSize(400,500);
                frame4.setVisible(true);
                JTable table3=new JTable();

                DefaultTableModel model=new DefaultTableModel();


                JScrollPane scroll;
                String[] columnName={"Name","Location","Team","No of points","No of 1st positions","No of 2nd positions","No of 3rd positions","No of races"};
                model.setColumnIdentifiers(columnName);
                table3.setModel(model);
                scroll=new JScrollPane(table3);

                table3.setBounds(30,40,200,300);

                frame4.add(scroll,BorderLayout.CENTER);
                frame4.setSize(600,600);


                Formula1Driver.firstPositions();     //Calling the sorting method

                for(int j=0;j<DriverList.size();j++){
                    model.addRow(new Object[]{String.valueOf(DriverList.get(j).getDriverName()),String.valueOf(DriverList.get(j).getDriverLocation()),String.valueOf(DriverList.get(j).getDriverTeam()),String.valueOf(DriverList.get(j).getNoOfPoints()),String.valueOf(DriverList.get(j).getNoOfFirstPositions()),String.valueOf(DriverList.get(j).getNoOfSecondPositions()),String.valueOf(DriverList.get(j).getNoOfThirdPositions()),String.valueOf(DriverList.get(j).getNoOfRaces())});

                }

            }
        });





    }














}








