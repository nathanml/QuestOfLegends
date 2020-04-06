package Characters.Monsters;

import Characters.Character;
import Characters.Heroes.Hero;

public abstract class Monster extends Character {
    protected int damage;
    protected int defense;
    protected int chance;

    public Monster(String n, int l, int dmg, int def, int dc){
        name = n;
        level = l;
        damage = dmg;
        defense = def;
        chance = dc;
        hp = 1000 * level;
        isAlive = true;
    }

    public void attack(Hero h) {
        //If hero doesn't dodge, inflict damage
        System.out.println(name + " attacked " + h.getName ());
        h.damage(damage * level);
        if(h.isAlive)
        {
            System.out.println(h.getName () + " hp : " + h.getHP ());
        }
    }

    @Override
    public boolean dodge() {
        double p = Math.random ();
        return (p <= (chance/100));
    }

    public void damage(int d){
        if(!dodge())
        {
            if(d > defense)
            {
                int damage = d - defense;
                hp -= damage;
                System.out.println(name + " lost " + damage + " hp");
                if(hp <= 0)
                    faint();
            }
            else System.out.println(name + " defended against the attack");
        }
        else System.out.println(name + " dodged the attack.");
    }

    public void printAttributes()
    {
        System.out.println(name + " :");
        System.out.println ("HP : " + hp);
        System.out.println("Damage : " + damage);
        System.out.println("Defense : " + defense);
        System.out.println("Dodge Chance : " + chance);
    }

    public void loseDefense() {
        defense *= 0.9;
    }

    public void loseDamage(){
        damage *= 0.9;
    }

    public void loseChance() {
        chance *= 0.9;
    }

    public int getDefense() {
        return defense;
    }

    public void move()
    {

    }

    public static void main(String[] args){

    }
}
