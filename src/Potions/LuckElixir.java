package Potions;

import Characters.Heroes.Hero;

public class LuckElixir extends Potion{

    public LuckElixir()
    {
        super("Luck Elixir",500,4,65);
    }

    @Override
    public void usePotion(Hero h) {
        h.increaseDexterity (attributeIncrease);
        System.out.println ("You've drunk the Luck Elixir. Your dexterity is now " + h.getDexterity ());
    }

    public static void main(String[] args)
    {

    }
}
