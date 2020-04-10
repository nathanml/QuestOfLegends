package Potions;

import Characters.Heroes.Hero;

public class Ambrosia extends Potion {

    public Ambrosia()
    {
        super("Ambrosia",100,8,150);
    }

    @Override
    public void usePotion(Hero h) {
        h.increaseAgility (attributeIncrease);
        h.increaseDexterity (attributeIncrease);
        h.increaseMana (attributeIncrease);
        h.increaseStrength (attributeIncrease);
        h.increaseHP (attributeIncrease);
        System.out.println("You've drunk Ambrosia. All of your attributes have been increased");
        h.printAttributes();
    }

    public static void main(String[] args)
    {

    }
}
