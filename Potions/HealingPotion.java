package Potions;

import Characters.Heroes.Hero;

public class HealingPotion extends Potion {

    public HealingPotion()
    {
        super("Healing Potion",250,1,100);
        name = "Healing Potion";
        price = 250;
        minLevel = 1;
        attributeIncrease = 100;
    }

    @Override
    public void usePotion(Hero h) {
        h.increaseHP(attributeIncrease);
        System.out.println ("You've drunk the Healing Potion. Your HP is now " + h.getHP ());
    }

    public static void main(String[] args)
    {

    }
}
