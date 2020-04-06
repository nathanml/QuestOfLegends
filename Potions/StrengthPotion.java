package Potions;

import Characters.Heroes.Hero;

public class StrengthPotion extends Potion{
    public StrengthPotion()
    {
        super("Strength Potion",200,1,75);
    }

    @Override
    public void usePotion(Hero h) {
        h.increaseStrength(attributeIncrease);
        System.out.println("You've drunk the Strength Potion. Your strength is now " + h.getStrength ());
    }

    public static void main(String[] args)
    {

    }
}
