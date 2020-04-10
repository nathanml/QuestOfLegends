package Weapons;
import Characters.Heroes.Hero;
import Main.*;

public class Weapon extends Item implements Sellable{
    int damage;

    public Weapon(String n, int cost, int level, int dmg)
    {
        name = n;
        price = cost;
        minLevel = level;
        damage = dmg;
    }

    public int getDamage(){
        return damage;
    }

    @Override
    public void sellItem(Hero h) {
        h.wallet.addMoney (price);
        h.removeWeapon (this);
        System.out.println("You've sold " + this.getName ());
        h.printWeapons ();
    }

    @Override
    public void buyItem(Hero h) {
        h.addWeapon (this);
    }

    public static void main(String[] args){

    }

}
