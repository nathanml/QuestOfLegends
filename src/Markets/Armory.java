package Markets;

import Armors.*;
import Main.*;
import Characters.Heroes.*;

public class Armory extends Market{

    public Armory(Hero h) {
        //Constructor for an armory
        super (h);
        items = new Armor[6];
        items[0] = new Platinum_Shield();
        items[1] = new Breastplate();
        items[2] = new Breastplate ();
        items[3] = new Full_Body_Armor ();
        items[4] = new Wizard_Shield ();
        items[5] = new Speed_Boots ();
        System.out.println("Welcome to the Armory!");
    }

    @Override
    public void sell(Hero h) {
        if(h.numArmors () < 0)
        {
            System.out.println("You don't have any armors to sell. Goodbye!");
        }
        else {
            h.printArmors ();
            System.out.println("Enter the number of the armor you want to sell or any other number to exit");
            while (!input.hasNextInt ())
            {
                System.out.println("Please enter an integer");
            }
            int in = input.nextInt ();
            if(in >= 0 && in < h.numArmors ())
            {
                Armor toSell = h.getArmor (in);
                toSell.sellItem (h);
                h.wallet.printWallet ();
            }
        }
    }

    public static void main(String[] args)
    {

    }
}
