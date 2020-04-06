package Markets;

import Characters.Heroes.Hero;
import Main.Player;

public class GrandMarket extends Market {

    public GrandMarket(Player p) {
        super (p);
    }

    public void chooseMarket()
    {
        System.out.println("Enter the number of the market you want to enter, or press 0 to exit");
        System.out.println("1. Armory");
        System.out.println("2. Weapons Market");
        System.out.println("3. Potions Market");
        System.out.println("4. Fire Market");
        System.out.println("5. Ice Market");
        System.out.println("6. Lightning Market");
    }

    public void enter()
    {
        System.out.println ("WELCOME TO THE GRAND MARKET");
        chooseMarket ();
        while (!input.hasNextInt ())
        {
            System.out.println("Please enter an integer");
            input.next ();
        }
        int in = input.nextInt ();
        System.out.println(in);
        while(in != 0)
        {
            if(in == 1)
            {
                Armory a = new Armory (currentPlayer);
                a.enter ();
                chooseMarket ();
            }
            if(in == 2)
            {
                WeaponsMarket w = new WeaponsMarket (currentPlayer);
                w.enter();
                chooseMarket ();
            }
            if(in == 3)
            {
                PotionMarket p = new PotionMarket (currentPlayer);
                p.enter ();
                chooseMarket ();
            }
            if(in == 4)
            {
                FireMarket f = new FireMarket (currentPlayer);
                f.enter ();
                chooseMarket ();
            }
            if(in == 5)
            {
                System.out.println(in);
                IceMarket i = new IceMarket (currentPlayer);
                i.enter ();
                chooseMarket ();
            }
            if(in == 6)
            {
                LightningMarket l = new LightningMarket (currentPlayer);
                l.enter ();
                chooseMarket ();
            }
            else {
                System.out.println("Not a valid input");
                while (!input.hasNextInt ()) {
                    System.out.println ("Please enter an integer");
                    input.next ();
                }
                in = input.nextInt ();
            }
        }
        System.out.println("Goodbye");
    }

    @Override
    public void sell(Hero h) {

    }
}
