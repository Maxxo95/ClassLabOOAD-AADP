/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

import java.util.ArrayList;

/**
 *
 * @author maxim
 * 
 * 
 * 
 * String[] teams = {"Ireland", "Brazil", "Argentina", "Japan", "Mexico", "Senegal", "Tunisia", "Qatar"};
 String teamName;
 */
import java.util.ArrayList;

public class Team {

    private ArrayList<Players> team = new ArrayList();
    private String teamName;

    // Constructor with parameters
    public Team( String teamName) {
        this.setTeam(team);
        this.setTeamName(teamName);
    }

    // Getter and setter for 'team'
    public ArrayList<Players> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Players> team) {
        this.team = team;
    }

    // Getter and setter for 'teamName'
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
      public void addPlayer(Players player) {
        team.add(player);
    }

    public void removePlayer(Players player) {
        team.remove(player);
    }

}

