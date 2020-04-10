package Main;

import Characters.Character;
import java.util.ArrayList;
import java.util.Scanner;

public class Team<T extends Character> implements Fightable {
    private String name; //Name of the team
    private static Scanner input = new Scanner(System.in);
    public int totalHealth;
    int level;      //Level of the team
    int current;    //Tracks index of current character
    ArrayList<T> characters = new ArrayList<T> ();  //List of characters on team

    //Used generics so that teams can consist of all any subclass of Character (hero and monster)

    //No-arg constructor creates team of heroes
    public Team(String n, int size)
    {
        name = n;
        totalHealth = 0;
        level = 1;
    }

    //Method for printing all the characters in a team
    public void printTeam()
    {
        for(int i=0; i<characters.size ();i++)
        {
            if(characters.get (i).isAlive){
                System.out.println(i + ". " + characters.get (i).getName());
            }
            else System.out.println();
        }
    }

    //Method for changing the current character (takes in index as input)
    public void changeCurrentCharacter(int n)
    {
        /* Method for updating the current player for a team*/
        if(n >= 0 && n < characters.size ())
        {
            current = n;
        }
        else System.out.println("Not a valid character index");

    }

    //Returns the current character
    public Character getCurrentCharacter(){
        /* Method for obtaining current character*/
        return characters.get (current);
    }

    //Method for adding character to team
    public void add(Character c){
        characters.add ((T) c);
        current = characters.indexOf (c);
        totalHealth += c.getHP ();
    }

    //Returns team name
    public String getName(){
        /* Method for obtaining team name*/
        return name;
    }

    //Sets level of a team
    public void setLevel(int l)
    {
        level = l;
    }

    //Returns size of team
    public int getSize(){
        return characters.size ();
    }

    public void updateHealth()
    {
        totalHealth = 0;
        for(int i=0; i<characters.size (); i++)
        {
            totalHealth += characters.get (i).getHP ();
        }
    }

    //Overridden method for causing damage to a team
    @Override
    public void damage(int d) {
        totalHealth -= d;
        if(totalHealth <= 0)
            loseFight ();
    }

    //Overridden method for attacking a character
    @Override
    public void attack(Character c) {
        characters.get(current).attack(c);
    }

    @Override
    public boolean dodge() {
        return characters.get (current).dodge ();
    }

    @Override
    public void loseFight() {
        for (int i=0; i<characters.size ();i++)
        {
            characters.get (i).loseFight ();
        }
    }

    @Override
    public void winFight() {
        for (int i=0; i<characters.size ();i++)
        {
            characters.get (i).winFight ();
        }

    }

    //Overridden method for displaying team stats
    @Override
    public void displayStats() {
        for(int i=0; i<characters.size (); i++)
        {
            System.out.println(name);
            System.out.println("Level: " + level);
            System.out.println("Main.Team Health = " + totalHealth);
            characters.get (i).displayStats ();
            System.out.println("Current Main.Player : " + characters.get (current).getName ());
        }

    }

    public Character getCharacter(int x) {
        return characters.get (x);
    }

    public void remove(T current) {
        for(int i=0; i<characters.size (); i++)
        {
            if(characters.get (i) == current){
                characters.remove (i);
                break;
            }
        }
    }
    public static void main(String[] args){

    }
}
