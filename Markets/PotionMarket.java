package Markets;

import Potions.*;
import Main.*;
import Characters.Heroes.*;

public class PotionMarket extends Market {

    public PotionMarket(Player p)
    {
        super (p);
        items = new Potion[6];
        items[0] = new HealingPotion();
        items[1] = new StrengthPotion ();
        items[2] = new MagicPotion ();
        items[3] = new LuckElixir ();
        items[4] = new MermaidTears ();
        items[5] = new Ambrosia ();
        System.out.println("Welcome to the Potion Market!");
    }

    @Override
    public void sell(Hero h) {
        if(h.numPotions() == 0)
        {
            System.out.println("You don't have any potions to sell. Goodbye!");
        }
        else {
            h.printPotions ();
            System.out.println("Enter the number of the potion you want to sell or any other number to exit");
            while (!input.hasNextInt ())
            {
                System.out.println("Please enter an integer");
            }
            int in = input.nextInt ();
            while(in < 0 || in > h.numPotions ())
            {
                System.out.println("Please enter an integer between 1 and " + h.numPotions ());
            }
            Potion toSell = h.getPotion(in);
            toSell.sellItem (h);
            h.wallet.printWallet ();
        }
    }
    public static void main(String[] args)
    {

    }
}
