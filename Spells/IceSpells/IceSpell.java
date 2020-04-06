package Spells.IceSpells;

import Characters.Heroes.Hero;
import Characters.Monsters.Monster;
import Spells.Spell;


public class IceSpell extends Spell {

    public IceSpell(String n, int cost, int level, int dmg, int mana){
        super(n,cost,level,dmg,mana);
    }

    @Override
    public void castSpell(Hero h, Monster m) {
        int finalDamage = damage + (h.getDexterity ()/10000)*damage;
        m.damage(finalDamage);
        h.loseMana(manaLevel);
        m.loseDamage ();
        System.out.println (h.getName () + " cast " + name + ", inflicting " + (finalDamage-m.getDefense()) +
                " damage and decreasing the damage of " + m.getName () + ".");
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
        h.addIceSpell (this);
    }

    @Override
    public void sellItem(Hero h) {
        h.wallet.addMoney (price);
        h.removeIceSpell (this);
        System.out.println("You've sold " + this.getName ());
        h.printArmors ();
    }

    @Override
    public int getLevel() {
        return minLevel;
    }

    public static void main(String[] args){

    }

}
