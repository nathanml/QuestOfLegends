package Spells.LightningSpells;
import Spells.Spell;
import Characters.Heroes.Hero;
import Characters.Monsters.Monster;

public class LightningSpell extends Spell{

    public LightningSpell(String n, int cost, int level, int dmg, int mana){
        super(n,cost,level,dmg,mana);
    }

    @Override
    public void castSpell(Hero h, Monster m) {
        int finalDamage = damage + (h.getDexterity ()/10000)*damage;
        m.damage(finalDamage);
        h.loseMana (manaLevel);
        m.loseChance();
        System.out.println (h.getName () + " cast " + name + ", inflicting " + (finalDamage-m.getDefense()) +
                " damage and decreasing the dodge chance of " + m.getName () + ".");
        System.out.println(m.getName () + " hp : " + m.getHP ());
    }

    public static void main(String[] args){

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
        h.addLightningSpell (this);
    }

    @Override
    public void sellItem(Hero h) {
        h.wallet.addMoney (price);
        h.removeLightningSpell(this);
        System.out.println("You've sold " + this.getName ());
        h.printLightningSpells ();
    }

    @Override
    public int getLevel() {
        return minLevel;
    }
}
