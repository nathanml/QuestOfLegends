package Markets;

import Characters.Heroes.Hero;
import Main.*;
import Spells.FireSpells.*;

public class FireMarket extends Market {
    private static FireSpell FlameTornado = new FireSpell ("Flame Tornado", 700, 4, 850, 300);
    private static FireSpell BreathOfFire = new FireSpell ("Breath of Fire",350,1 ,450, 100);
    private static FireSpell HeatWave = new FireSpell ("Heat Wave",50,2,600,150);
    private static FireSpell LavaCommet = new FireSpell ("Lava Commet", 800,7,1000,550);

    public FireMarket(Player p) {
        super (p);
        items = new FireSpell[4];
        items[0] = FlameTornado;
        items[1] = BreathOfFire;
        items[2] = HeatWave;
        items[3] = LavaCommet;
        System.out.println("Welcome to the Fire Market!");
    }

    @Override
    public void sell(Hero h) {
        if(h.numFireSpells () < 0)
        {
            System.out.println("You don't have any fire spells to sell. Goodbye!");
        }
        else {
            h.printFireSpells ();
            System.out.println("Enter the number of the fire spell you want to sell or any other number to exit");
            while (!input.hasNextInt ())
            {
                System.out.println("Please enter an integer");
            }
            int in = input.nextInt ();
            if(in >= 0 && in < h.numFireSpells ())
            {
                FireSpell toSell = h.getFireSpell (in);
                toSell.sellItem (h);
                h.wallet.printWallet ();
            }
        }
    }

    public static void main(String[] args)
    {

    }
}
