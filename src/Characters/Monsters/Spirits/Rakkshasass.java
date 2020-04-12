package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class Rakkshasass extends Spirit {

    public Rakkshasass()
    {
        super("Rakkshasass",9,550,600,35);
        piece = new Piece (name, "R", false);
    }

    @Override
    public Spirit copy() {
        return new Rakkshasass ();
    }

    public static void main(String[] args)
    {

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
