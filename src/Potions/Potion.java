package Potions;
import Characters.Heroes.Hero;
import Main.*;

public abstract class Potion extends Item implements Sellable{
    protected int attributeIncrease;

    public Potion(String n, int cost, int level, int increase)
    {
        name = n;
        price = cost;
        minLevel = level;
        attributeIncrease = increase;
    }

    public abstract void usePotion(Hero h);

    @Override
    public void buyItem(Hero h) {
        if(h.level >= minLevel){
            h.wallet.spendMoney (this.price);
            h.addPotion (this);
        }
    }

    @Override
    public void sellItem(Hero h) {
        h.wallet.addMoney (price);
        h.removePotion (this);
        System.out.println("You've sold " + this.getName ());
        h.printPotions ();
    }

    public static void main(String[] args){

    }
}
