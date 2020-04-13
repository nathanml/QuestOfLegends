package Main;

import Characters.Heroes.Hero;
import Markets.HeroNexus;
import Tiles.*;

import java.util.Scanner;

public class Player {
    private String name;    //Player's name
    public Team<Hero> heroes;   //Player's team of heroes

    public Player(String n, int t){
        /*Constructor method for player*/
        name = n;
        heroes = new Team<Hero> ("Heroes", t);
    }

    public String getName(){
        /*Method for getting a player's name*/
        return name;
    }

    public void move(Board board,Team monsters) {
        //Method for moving on the game board

        for(int i=0; i<heroes.getSize (); i++)
        {
            heroes.changeCurrentCharacter (i);
            Hero currentHero = (Hero) heroes.getCurrentCharacter ();
            System.out.println(currentHero.getName () + ", your turn.");
            currentHero.move(board, monsters);
            if(board.tileAt (currentHero.currentRow,currentHero.currentCol).getName ().equals ("Nexus Tile") && currentHero.currentRow == 7)
            {
                HeroNexus M = new HeroNexus (currentHero);
                M.enter ();
            }
            else if(board.tileAt (currentHero.currentRow,currentHero.currentCol).getName ().equals ("Bush Tile"))
            {
                int increase = currentHero.getDexterity ()/10;
                currentHero.increaseDexterity (increase);
                System.out.println(currentHero.getName () + ", your dexterity is now " + currentHero.getDexterity ());
            }
            else if(board.tileAt (currentHero.currentRow,currentHero.currentCol).getName ().equals ("Kuolo Tile"))
            {
                int increase = currentHero.getStrength ()/10;
                currentHero.increaseStrength (increase);
                System.out.println(currentHero.getName () + ", your strength is now " + currentHero.getStrength ());
            }
            else if(board.tileAt (currentHero.currentRow,currentHero.currentCol).getName ().equals ("Cave Tile"))
            {
                int increase = currentHero.getAgility ()/10;
                currentHero.increaseAgility (increase);
                System.out.println(currentHero.getName () + ", your agility is now " + currentHero.getAgility ());
            }
            board.printBoard ();
        }
    }


    public static void main(String[] args){

    }
}
