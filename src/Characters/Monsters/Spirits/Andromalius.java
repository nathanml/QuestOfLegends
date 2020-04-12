package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class Andromalius extends Spirit {

    public Andromalius()
    {
        super("Andromalius",3,550,450,25);
        piece = new Piece (name, "A", false);
    }

    @Override
    public Spirit copy() {
        return new Andromalius ();
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
