package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class Andrealphus extends Spirit {

    public Andrealphus()
    {
        super("Andrealphus",2,600,500,40);
        piece = new Piece (name, "A", false);
    }

    @Override
    public Spirit copy() {
        return new Andrealphus ();
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
