/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Utilities {
     boolean validTeam = false;
         Scanner sc = new Scanner(System.in);
                    String name;
                    int number = 0;
                    String birth;
                    String position;
                    int goalsScored = 0;
                    String background;
                    boolean validPlayer = false;
                    Players playerToAdd = new Players();
           public Players addPlayer(){         
                    System.out.println("Please enter the player's name: ");
                    name = sc.nextLine();
                     
                    playerToAdd.setName(name);
                    
                    System.out.println("Please enter the player's number: ");
                    do {
                        try {
                            number = Integer.parseInt(sc.nextLine()); 
                            playerToAdd.setNumber(number);
                            if (number < 1) {
                                System.out.println("Please enter a positive integer");
                            } else validPlayer = true;
                                playerToAdd.setvaliPlayer(true);
                        } catch (Exception e) {
                            System.out.println("That is not a number. please try again!");
                        }
                    } while (!playerToAdd.getvalidPlayer());                                              
                    System.out.println("Please enter the player's date of birth: ");
                    birth = sc.nextLine();
                    playerToAdd.setBirth(birth);
                    System.out.println("Please enter the player's position: ");
                    position = sc.nextLine(); 
                    playerToAdd.setPosition(position);
                    System.out.println("Please enter the number of goals the player has scored: ");
                  
                    validPlayer = false;
                    do {
                        try {
                            goalsScored = Integer.parseInt(sc.nextLine()); 
                            playerToAdd.setGoalsScored(goalsScored);
                            if (goalsScored < 1) {
                                System.out.println("Please enter a positive integer");
                            } else validPlayer = true;

                        } catch (Exception e) {
                            System.out.println("That is not a number. please try again!");
                        }
                    } while (!validPlayer);     
                    System.out.println("Please enter the player's background: ");
                    background = sc.nextLine();
                    playerToAdd.setBackground(background);
                    System.out.println("Thank you for entering a player"); 
                  
                    return playerToAdd;
           }
}
