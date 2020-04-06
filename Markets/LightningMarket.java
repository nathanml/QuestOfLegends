package Markets;

import Main.*;
import Spells.LightningSpells.*;
import Characters.Heroes.*;

public class LightningMarket extends Market{
    private static LightningSpell LightningDagger = new LightningSpell ("Lightning Dagger", 400,1,500,150);
    private static LightningSpell ThunderBlast = new LightningSpell ("Thunder Blast", 750,4,950,400);
    private static LightningSpell ElectricArrows = new LightningSpell ("Electric Arrows", 550,5,650,200);
    private static LightningSpell SparkNeedles = new LightningSpell ("Spark Needles", 500,2,600,200);


    public LightningMarket(Player p)
    {
        super (p);
        items = new LightningSpell[4];
        items[0] = LightningDagger;
        items[1] = ThunderBlast;
        items[2] = ElectricArrows;
        items[3] = SparkNeedles;
        System.out.println("Welcome to the Lightning Market!");
    }

    @Override
    public void sell(Hero h) {
        if(h.numLightningSpells() < 0)
        {
            System.out.println("You don't have any lightning spells to sell. Goodbye!");
        }
        else {
            h.printLightningSpells ();
            System.out.println("Enter the number of the lightning spell you want to sell or any other number to exit");
            while (!input.hasNextInt() )
            {
                System.out.println("Please enter an integer");
            }
            int in = input.nextInt ();
            if(in >=0 && in < h.numLightningSpells ())
            {
                LightningSpell toSell = h.getLightningSpell(in);
                toSell.sellItem (h);
                h.wallet.printWallet ();
            }
        }
    }

    public static void main(String[] args)
    {

    }
}
