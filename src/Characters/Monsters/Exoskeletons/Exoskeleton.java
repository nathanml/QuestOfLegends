package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Characters.Monsters.Monster;
import Main.Piece;

public class Exoskeleton extends Monster {


    public Exoskeleton(String n, int lev, int dmg, int def, int dc)
    {
        super(n,lev,dmg,def,dc);
        piece = new Piece (name, "E", false);
    }

    @Override
    public void attack(Character c) {

    }

    @Override
    public void loseFight() {

    }

    @Override
    public void winFight() {

    }

    @Override
    public void displayStats() {

    }

    public static void main(String[] args){

    }

}
