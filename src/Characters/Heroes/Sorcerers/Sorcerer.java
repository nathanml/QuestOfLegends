package Characters.Heroes.Sorcerers;

import Characters.Character;
import Characters.Heroes.Hero;
import Main.Piece;
import Spells.Spell;

public class Sorcerer extends Hero {

    public Sorcerer(String n, int m, int s, int a, int d, int mon, int x){
        super(n,m,s,a,d,mon,x);
        piece = new Piece (name, "S", true);
    }

    @Override
    public void levelUp() {
        level++;
        nextLevel = level * 10;
        hp = 100 * level;
        mana = mana + mana / 10;
        strength = strength + strength/20;
        dexterity = dexterity + dexterity/10;
        agility = agility + agility/10;
        System.out.println("CONGRATULATIONS! You've leveled up. You are now a level " + level + " hero");
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
}
