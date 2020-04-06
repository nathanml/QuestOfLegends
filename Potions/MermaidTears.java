package Potions;

import Characters.Heroes.Hero;

public class MermaidTears extends Potion {

    public MermaidTears()
    {
        super("Mermaid Tears",850,5,100);
    }

    @Override
    public void usePotion(Hero h) {
        h.increaseAgility (attributeIncrease);
        System.out.println ("You've drunk Mermaid Tears. Your agility is now " + h.getAgility ());
    }

    public static void main(String[] args)
    {

    }
}
