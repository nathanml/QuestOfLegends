package Characters.Heroes.Paladins;

import Characters.Character;
import Characters.Heroes.Hero;
import Spells.Spell;

public class Paladin extends Hero {

    public Paladin(String n, int m, int s, int a, int d, int mon, int x)
    {
        super(n,m,s,a,d,mon,x);
    }

    public static void main(String[] args){

    }

    @Override
    public void attack(Character c) {

    }

    @Override
    public void winFight() {

    }

    @Override
    public void displayStats() {

    }

    public void levelUp()
    {
        level++;
        nextLevel = level * 10;
        hp = 100 * level;
        mana = mana + mana / 10;
        strength = strength + strength/10;
        dexterity = dexterity + dexterity/10;
        agility = agility + agility/20;
        System.out.println("CONGRATULATIONS! You've leveled up. You are now a level " + level + " hero");
    }
}
