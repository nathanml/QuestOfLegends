package Armors;

import Characters.Heroes.Hero;
import Main.*;

public class Armor extends Item implements Sellable{
    //protected String name;
    //protected int price;

    protected int damageReduction;

    public Armor(String n, int p, int l, int r) {
        //Constructor for various types of armors
        name = n;
        price = p;
        minLevel = l;
        damageReduction = r;
    }

    @Override
    public void buyItem(Hero h) {
        h.wallet.spendMoney (price);
        h.addArmor (this);

    }

    @Override
    public void sellItem(Hero h) {
        h.wallet.addMoney (price);
        h.removeArmor (this);
        System.out.println("You've sold " + this.getName ());
        h.printArmors ();
    }

    public int getDamageReduction()
    {
        return damageReduction;
    }

    public static void main(String[] args){

    }
}
