package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class Melchiresas extends Spirit {

    public Melchiresas()
    {
        super("Melchiresas",7,350,150,75);
        piece = new Piece (name, "M", false);
    }

    @Override
    public Spirit copy() {
        return new Melchiresas ();
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
