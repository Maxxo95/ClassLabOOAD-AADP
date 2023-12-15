/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aadp_lab_soccersimulator;

/**
 *
 * @author maxim
 */
public class Players {
     /*  + "name VARCHAR(30) NOT NULL,"
                                + "number INT NOT NULL PRIMARY KEY,"
                                + "birth VARCHAR(30),"
                                + "position VARCHAR(30),"
                                + "goalsScored INT,"
                                + "background TEXT(1000));"*/
    private String name;
    private int number = -1;
    private String birth;
    private String position;
    private int goalsScored;
    private String background;
   private boolean validPlayer = false ;
    // Default constructor
    public Players() {
    }

    // Constructor with parameters
    public Players(String name, int number, String birth, String position, int goalsScored, String background) {
       this.setName(name);
        this.setNumber(number);
        this.setBirth(birth);
        this.setPosition(position);
        this.setGoalsScored(goalsScored);
       this.setBackground(background);
       this.setvaliPlayer(validPlayer);
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

  
    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    
    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
    public void setvaliPlayer(Boolean validPlayer){
        this.validPlayer = validPlayer;
    }
    public boolean getvalidPlayer() {
        return validPlayer;
    }
}



