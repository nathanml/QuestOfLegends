package Main;

import Characters.Heroes.Hero;
import Markets.HeroNexus;
import Tiles.*;

import java.util.Scanner;

public class Player {
    public String name;    //Player's name
    public Team<Hero> heroes;   //Player's team of heroes

    public Player(String n, int t){
        /*Constructor method for player*/
        name = n;
        heroes = new Team<Hero> ("Heroes", t);
    }

    public void move(Board board,Team monsters) {
        //Method for moving on the game board

        //Loop through each hero
        for(int i=0; i<heroes.getSize (); i++)
        {
            heroes.changeCurrentCharacter (i);
            Hero currentHero = (Hero) heroes.getCurrentCharacter ();
            System.out.println(currentHero.getName () + ", your turn.");
            currentHero.move(board, monsters);
            Tile currentTile = board.tileAt (currentHero.currentRow, currentHero.currentCol);

            //If nexus tile direct to market
            if(board.tileAt (currentHero.currentRow, currentHero.currentCol).getName().equals ("Nexus Tile") && currentHero.currentRow == 7)
            {
                currentTile.performAction (currentHero);
            }

            //If bush tile, increase dexterity
            else if(board.tileAt (currentHero.currentRow,currentHero.currentCol).getName ().equals ("Bush Tile"))
            {
                currentTile.performAction (currentHero);
            }

            //If Kuolo Tile, increase
            else if(board.tileAt (currentHero.currentRow,currentHero.currentCol).getName ().equals ("Kuolo Tile"))
            {
                currentTile.performAction (currentHero);
            }
            else if(board.tileAt (currentHero.currentRow,currentHero.currentCol).getName ().equals ("Cave Tile"))
            {
                currentTile.performAction (currentHero);
            }
            board.printBoard ();
        }
    }


    public static void main(String[] args){

    }
}
