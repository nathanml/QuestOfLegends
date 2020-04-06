package Potions;

import Characters.Heroes.Hero;

public class MagicPotion extends Potion {

    public MagicPotion()
    {
        super("Magic Potion",350,2,100);
    }

    @Override
    public void usePotion(Hero h) {
        h.increaseMana (attributeIncrease);
        System.out.println ("You've drunk the Magic Potion. Your mana is now " + h.getMana ());
    }

    public static void main(String[] args)
    {

    }
}
