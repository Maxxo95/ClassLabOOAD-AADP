/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Sam Please put the names and student numbers of the team here:
 *
 * Name 1: Number 1:
 *
 * Name 2: Number 2:
 *
 * Name 3: Number 3:
 *
 * Name 4: Number 4
 *
 */
public class AADP_Lab_SoccerSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Team currentTeam = new Team("");
        String dbName = "world_cup";
        Utilities utilities = new Utilities();
        String[] teams = {"Ireland", "Brazil", "Argentina", "Japan", "Mexico", "Senegal", "Tunisia", "Qatar"};
        Players playerAdd = new Players();
        // Loop through each team name and create a Team object

        String DB_URL = "jdbc:mysql://localhost/" + dbName;
        String USER = "football";
        String PASS = "Java is almost as good as football";
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
         try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE SCHEMA IF NOT EXISTS " + dbName +";");
            stmt.execute("USE " + dbName + ";");
            for (String team : teams) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS "+ team + " ("
                                + "name VARCHAR(30) NOT NULL,"
                                + "number INT NOT NULL PRIMARY KEY,"
                                + "birth VARCHAR(30),"
                                + "position VARCHAR(30),"
                                + "goalsScored INT,"
                                + "background TEXT(1000));"
                );                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int option;

        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Welcome! What would you like to do today? Please enter the number corresponding to your choice.");
            System.out.println("1. Enter a new player to a team.");
            System.out.println("2. See the players on a team.");
            System.out.println("3. Simulate a number of matches.");
            System.out.println("4. Exit the programme.");
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option == 1) {

                    System.out.println("Please follow the instructions to enter player data.");
                    currentTeam = utilities.checkTeams();
                    playerAdd = utilities.addPlayer();
                    System.out.println(playerAdd.getName() + playerAdd.getNumber() + playerAdd.getBirth() + playerAdd.getPosition() + playerAdd.getGoalsScored() + playerAdd.getBackground());

                    try {
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();
                        stmt.execute(
                                String.format("INSERT INTO %s (name, number, birth, position, goalsScored, background) "
                                        + "VALUES (\"%s\", %d, \"%s\", \"%s\", %d,  \"%s\") ;",
                                        playerAdd.getName(), playerAdd.getNumber(), playerAdd.getBirth(), playerAdd.getPosition(), playerAdd.getGoalsScored(), playerAdd.getBackground())
                        );
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else if (option == 2) {

                    System.out.println("Please follow the instructions to get player data.");
                    currentTeam = utilities.checkTeams();

                    try {
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * from " + currentTeam.getTeamName() + ";");
                        String name;
                        int number;
                        String birth;
                        String position;
                        int goalsScored;
                        String background;
                        while (rs.next()) {
                            name = rs.getString("name");                           
                            number = rs.getInt("number");                           
                            birth = rs.getString("birth");
                            position = rs.getString("position");
                            goalsScored = rs.getInt("goalsScored");
                            background = rs.getString("background");
                            System.out.println(String.format("Name: %s -- Number: %d -- DoB: %s -- Position: %s -- Number of goals scored: %d", name, number, birth, position, goalsScored));
                            System.out.println("Background:");
                            System.out.println(background);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else if (option == 3) {
                    System.out.println("How many matches would you like to simulate?");
                    MatchSimulator.simulateMatches();
                } else if (option == 4) {
                    System.out.println("Goodbye, and thank you for using the SoccerSimulator!");
                    exit = true;
                } else {
                    System.out.println("That is an invalid number. Please try again!");
                }
            } catch (Exception e) {
                System.out.println("That is not a number. Please try again!");
            }
        } while (!exit);
    }
}
