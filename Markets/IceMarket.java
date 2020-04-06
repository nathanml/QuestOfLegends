package Markets;

import Main.Player;
import Markets.Market;
import Spells.IceSpells.IceSpell;
import Characters.Heroes.*;

public class IceMarket extends Market {
    private IceSpell SnowCannon = new IceSpell ("Snow Canon", 500,2,650,250);
    private IceSpell IceBlade = new IceSpell ("Ice Spell", 250,1,450,100);
    private IceSpell FrostBlizzard = new IceSpell ("Frost Blizzard",750,5,850,350);
    private IceSpell ArcticStorm = new IceSpell ("Arctic Storm",700,6,800,300);

    public IceMarket(Player p)
    {
        super (p);
        items = new IceSpell[4];
        items[0] = IceBlade;
        items[1] = SnowCannon;
        items[2] = FrostBlizzard;
        items[3] = ArcticStorm;
        System.out.println("Welcome to the Ice Market!");
    }
    @Override
    public void sell(Hero h) {
        if(h.numIceSpells () < 0)
        {
            System.out.println("You don't have any ice spells to sell. Goodbye!");
        }
        else {
            h.printIceSpells ();
            System.out.println("Enter the number of the ice spell you want to sell or any other number to exit");
            while (!input.hasNextInt ())
            {
                System.out.println("Please enter an integer");
            }
            int in = input.nextInt ();
            if(in >= 0 && in < h.numIceSpells ())
            {
                IceSpell toSell = h.getIceSpell (in);
                toSell.sellItem (h);
                h.wallet.printWallet ();
            }

        }
    }
    public static void main(String[] args)
    {

    }

}
