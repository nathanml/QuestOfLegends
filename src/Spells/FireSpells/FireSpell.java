package Spells.FireSpells;


import Spells.Spell;
import Characters.Heroes.*;
import Characters.Monsters.*;

public class FireSpell extends Spell {

    public FireSpell(String n, int cost, int level, int dmg, int mana){
        super(n,cost,level,dmg,mana);
    }

    @Override
    public void castSpell(Hero h, Monster m) {
        int finalDamage = damage + (h.getDexterity()/10000)*damage;
        m.damage(finalDamage);
        h.loseMana(manaLevel);
        m.loseDefense();
        System.out.println (h.getName () + " cast " + name + ", inflicting " + (finalDamage-m.getDefense()) +
                " damage and decreasing the defense of " + m.getName () + ".");
        System.out.println(m.getName () + " hp : " + m.getHP ());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void buyItem(Hero h) {
        h.wallet.spendMoney (price);
        h.addFireSpell (this);
    }

    @Override
    public void sellItem(Hero h) {
        h.wallet.addMoney (price);
        h.removeFireSpell (this);
        System.out.println("You've sold " + this.getName ());
        h.printFireSpells ();
    }

    @Override
    public int getLevel() {
        return minLevel;
    }

    public static void main(String[] args){

    }
}
