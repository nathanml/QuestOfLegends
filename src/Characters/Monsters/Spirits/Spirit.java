package Characters.Monsters.Spirits;

import Characters.Character;
import Characters.Monsters.Monster;
import Main.Piece;

public class Spirit extends Monster {

    public Spirit(String n, int lev, int dmg, int def, int dc)
    {
        super(n,lev,dmg,def,dc);
        piece = new Piece (name, "S", false);
    }

    public static void main(String[] args){

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
}
