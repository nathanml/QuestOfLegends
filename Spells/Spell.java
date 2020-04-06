package Spells;
import Characters.Heroes.Hero;
import Characters.Monsters.Monster;
import Main.*;

public abstract class Spell implements Sellable{
    protected String name;
    protected int price;
    protected int minLevel;
    protected int damage;
    protected int manaLevel;

    public Spell(String n, int cost, int level, int dmg, int mana)
    {
        name = n;
        price = cost;
        minLevel = level;
        damage = dmg;
        manaLevel = mana;
    }


    public String getName(){return name;}

    public int getMana() {return manaLevel;}

    public abstract void castSpell(Hero h, Monster m);

    public static void main(String[] args){

    }

}
