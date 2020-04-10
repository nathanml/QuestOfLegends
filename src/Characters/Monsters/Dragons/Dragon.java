package Characters.Monsters.Dragons;

import Characters.Character;
import Characters.Monsters.Monster;
import Main.Piece;

public class Dragon extends Monster {

    public Dragon(String n, int l, int dmg, int def, int dc){
        super(n,l,dmg,def,dc);
        piece = new Piece (name, "D", false);
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
