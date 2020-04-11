package Main;

import Characters.Heroes.Hero;
import Tiles.*;

import java.util.Scanner;

public class Player {
    static Scanner input = new Scanner(System.in);
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
            System.out.println(currentHero.getName ());
            System.out.println("---------");
            currentHero.printAttributes ();
            currentHero.checkInventory ();
            currentHero.move(board, monsters);
        }
    }
        /*
        System.out.println("Enter your move: ");
        while (!input.hasNext ()){
            System.out.println("Invalid input, please enter your move: ");
        }
        String in = input.next ();
        while (!(in.equals ("A") || in.equals ("a")||in.equals ("W") || in.equals ("w") ||
                in.equals ("W")||in.equals ("S") || in.equals ("s")||
                in.equals ("D") || in.equals ("d")||in.equals ("Q") ||in.equals("q") ||
                in.equals ("I") || in.equals ("i")|| in.toLowerCase ().equals ("instructions")))
        {
            System.out.println("Not a valid input, please enter your move");
            in = input.next ();
        }

        if(in.equals ("I") || in.equals ("i"))
        {
            for(int i=0; i<heroes.getSize (); i++)
            {
                heroes.changeCurrentCharacter (i);
                Hero currentHero = (Hero) heroes.getCurrentCharacter ();
                System.out.println(currentHero.getName ());
                System.out.println("---------");
                currentHero.printAttributes ();
                currentHero.checkInventory ();
            }
            board.printBoard ();
            in = input.next ();
        }

        if(in.toLowerCase ().equals ("instructions"))
        {
            Quest.printInstructions();
            board.printBoard ();
            in = input.next();
        }



        if(in.equals ("A") || in.equals ("a")){
            if(board.isValid (currentRow, currentCol-1)){
                if(!board.isMarket (currentRow,currentCol))
                    board.removeTile (currentRow,currentCol);
                else
                    board.tileAt (currentRow,currentCol).hasHeroPiece = false;
                currentCol -= 1;
                if(board.isMarket (currentRow, currentCol))
                {
                    board.tileAt (currentRow,currentCol).hasHeroPiece = true;
                    //board.printBoard ();
                }
                else {
                    board.setTile (currentRow,currentCol, pieces[1]);
                   // board.printBoard ();
                }
            }
            else{
                System.out.println("Not a valid tile. Please enter your move:");
            }
        }

        /*
         * CASE 2: Move Up
         *
        else if(in.equals ("W") || in.equals ("w"))
        {
            if(board.isValid (currentRow - 1, currentCol)) {
                if(!board.isMarket (currentRow,currentCol))
                    board.removeTile (currentRow,currentCol);
                else
                    board.tileAt (currentRow,currentCol).hasHeroPiece = false;
                currentRow -= 1;
                if(board.isMarket (currentRow, currentCol))
                {
                    board.tileAt (currentRow,currentCol).hasHeroPiece = true;
                    //board.printBoard ();

                }
                else {
                    board.setTile (currentRow,currentCol, pieces[1]);
                    //board.printBoard ();
                }
            }
            else {
                System.out.println("Not a valid tile. Please enter your move: ");
            }
        }
        /*
         * CASE 3: Move down
         *
        else if(in.equals ("S") || in.equals ("s")){
            if(board.isValid (currentRow + 1, currentCol)){
                if(!board.isMarket (currentRow,currentCol))
                    board.removeTile (currentRow,currentCol);
                else
                    board.tileAt (currentRow,currentCol).hasHeroPiece = false;
                currentRow += 1;
                if(board.isMarket (currentRow, currentCol))
                {
                    board.tileAt (currentRow,currentCol).hasHeroPiece = true;
                    //board.printBoard ();

                }
                else {
                    board.setTile (currentRow,currentCol, pieces[1]);
                    //board.printBoard ();
                }
            }
            else {
                System.out.println("Not a valid tile. Please enter your move: ");
            }
        }

        /*
         * CASE 4: Move Right
         *
        else if(in.equals ("D") || in.equals ("d")){
            if(board.isValid (currentRow, currentCol+1)){
                if(!board.isMarket (currentRow,currentCol))
                    board.removeTile (currentRow,currentCol);
                else
                    board.tileAt (currentRow,currentCol).hasHeroPiece = false;
                currentCol += 1;
                if(board.isMarket (currentRow, currentCol))
                {
                    board.tileAt (currentRow,currentCol).hasHeroPiece = true;

                }
                else {
                    board.setTile (currentRow,currentCol, pieces[1]);
                }
            }
            else{
                System.out.println("Not a valid tile. Please enter your move:");
            }
        }

        else {
            System.out.println("Goodbye");
            System.exit (0);
        }

        */
    }

    //Method for determining if player's current hero can afford an item
    public boolean canAfford(Sellable i) {
        Hero currentHero = (Hero) heroes.getCurrentCharacter ();
        return (i.getPrice () <= currentHero.wallet.getMoney ());
    }

    //Returns tile of hero team
    public Tile getCurrentTile(Board b)
    {
        return b.tileAt (currentRow, currentCol);
    }

    public static void main(String[] args){

    }
}
