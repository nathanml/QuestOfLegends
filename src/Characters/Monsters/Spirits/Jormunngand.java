package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class Jormunngand extends Spirit {

    public Jormunngand()
    {
        super("Jormungand",8,600,900,20);
        piece = new Piece (name, "J", false);
    }

    @Override
    public Spirit copy() {
        return new Jormunngand ();
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
