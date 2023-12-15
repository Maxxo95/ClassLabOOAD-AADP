/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.util.Scanner;

/**
 *
 * @author maxim
 */ //int numMatches = 0;

//Interface??
public class MatchSimulator{

    static void simulateMatches() {
                String[] teams = {"Ireland", "Brazil", "Argentina", "Japan", "Mexico", "Senegal", "Tunisia", "Qatar"};
        Scanner sc = new Scanner(System.in);

       Boolean validNum = false;
                    int numMatches = 0;
                    do {
                        try {
                            numMatches = Integer.parseInt(sc.nextLine());
                            if (numMatches < 1) {
                                System.out.println("Please enter a positive integer");
                            } else {
                                validNum = true;
                            }

                        } catch (Exception e) {
                            System.out.println("That is not a number. please try again!");
                        }
                    } while (!validNum);
                    for (int matchNum = 1; matchNum <= numMatches; matchNum++) {
                        int team1Num = (int) (Math.floor(Math.random() * teams.length));
                        String team1 = teams[team1Num];
                        int team2Num;
                        do {
                            team2Num = (int) (Math.floor(Math.random() * teams.length));
                        } while (team1Num == team2Num);
                        String team2 = teams[team2Num];
                        int team1Score = (int) (Math.floor(Math.random() * 6));
                        int team2Score = (int) (Math.floor(Math.random() * 6));
                        System.out.println("Time for mathch: " + matchNum);
                        if (team1Score > team2Score) {
                            System.out.println(String.format("Congratulation %s! %s scored %d goals and %s scored %d goals.", team1, team1, team1Score, team2, team2Score));
                        } else if (team1Score < team2Score) {
                            System.out.println(String.format("Congratulation %s! %s scored %d goals and %s scored %d goals.", team2, team1, team1Score, team2, team2Score));
                        } else {
                            System.out.println(String.format("It was a draw!! %s scored %d goals and %s scored %d goals.", team1, team1Score, team2, team2Score));
                        }
                    }    }

    
}
