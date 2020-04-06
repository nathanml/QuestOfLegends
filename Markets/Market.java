package Markets;

import Main.*;
import java.util.Scanner;
import Characters.Heroes.*;

public abstract class Market {
    public static Scanner input = new Scanner (System.in);
    public static Player currentPlayer;
    protected Sellable[] items;

    public Market(Player p){
        //Constructor method--randomly generates market
        currentPlayer = p;
    }

    public void displayItems()
    {
        for(int i = 0; i < items.length; i++)
        {
            System.out.println(i + ". " + items[i].getName () + " || REQUIRED LEVEL : " + items[i].getLevel () + " || PRICE : " + items[i].getPrice ());
        }
    }

    public abstract void sell(Hero h);

    //Method for when heroes enter market
    public void enter() {

        //Loop through all players on team and allow them to buy something
        for(int i=0; i<currentPlayer.heroes.getSize (); i++)
        {
            currentPlayer.heroes.changeCurrentCharacter (i);
            System.out.println(currentPlayer.heroes.getCurrentCharacter ().getName () + ", would you like to buy anything? [Y/N]");
            //while(!input.hasNext ())
              //  System.out.println("Not a valid input. Would you like to buy anything? [Y/N]");
            //}
            String in = input.next();
            //CASE 1: Current hero wants to buy an item
            while(in.equals ("Y") || in.equals ("y"))
            {
                displayItems ();
                System.out.println("Enter the number of the item you would like to buy: ");
                while(!input.hasNextInt ())
                    System.out.println("Please enter an integer");
                int x = input.nextInt ();
                if(x >= 0 && x < items.length)
                {
                    if(currentPlayer.canAfford (items[x]) && items[x].getLevel() <= currentPlayer.heroes.getCurrentCharacter ().level)
                    {
                        Hero current = (Hero) currentPlayer.heroes.getCurrentCharacter ();
                        items[x].buyItem (current);
                        System.out.println("You've bought the " + items[x].getName ());
                        current.wallet.spendMoney (items[x].getPrice ());
                        current.wallet.printWallet ();
                        System.out.println("Would you like to buy another item? [Y/N]");
                        in = input.next ();
                    }
                    else if(!currentPlayer.canAfford (items[x]))
                    {
                        System.out.println("You cannot afford this item. Would you like to buy another? [Y/N]");
                        in = input.next ();
                    }
                    else{
                        System.out.println("You are not a high enough level for this item. Would you like to buy another? [Y/N]");
                        in = input.next ();
                    }
                }
                
            }

            //CASE 2: Hero doesn't want to buy. Check if hero wants to sell.
            if(in.equals ("N")|| in.equals ("n"))
            {
                System.out.println("Would you like to sell an item? [Y/N]");
                in = input.next ();
                while(in.equals ("Y") || in.equals ("y"))
                {
                    Hero seller = (Hero) currentPlayer.heroes.getCurrentCharacter ();
                    sell(seller);
                    System.out.println("Would you like to sell another item? [Y/N]");
                    in = input.next ();
                }
            }

        }
        System.out.println("Goodbye!");      //Say goodbye once all heroes have bought desired items
    }

    public static void main(String[] args)
    {

    }
}
