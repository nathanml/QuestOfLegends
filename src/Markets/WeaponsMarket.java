package Markets;
import Characters.Heroes.Hero;
import Main.*;
import Weapons.*;

public class WeaponsMarket extends Market {

    public WeaponsMarket(Hero h) {
        super (h);
        items = new Weapon[7];
        items[0] = new Sword();
        items[1] = new Bow();
        items[2] = new Scythe();
        items[3] = new Axe();
        items[4] = new Shield();
        items[5] = new TSword();
        items[6] = new Dagger();
        System.out.println("Welcome to the weapons market!");
    }

    @Override
    public void sell(Hero h) {
        if(h.numWeapons() < 0)
        {
            System.out.println("You don't have any weapons to sell. Goodbye!");
        }
        else {
            h.printWeapons ();
            System.out.println("Enter the number of the weapon you want to sell or any other number to exit");
            while (!input.hasNextInt ())
            {
                System.out.println("Please enter an integer");
            }
            int in = input.nextInt ();
            if(in >= 0 &&  in < h.numWeapons ())
            {
                Weapon toSell = h.getWeapon(in);
                toSell.sellItem (h);
                h.wallet.printWallet ();
            }
        }
    }

    public static void main(String[] args)
    {

    }
}
