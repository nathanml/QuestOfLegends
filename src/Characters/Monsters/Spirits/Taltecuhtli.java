package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class Taltecuhtli extends Spirit {

    public Taltecuhtli()
    {
        super("Taltecuhtli",10,300,200,50);
        piece = new Piece (name, "J", false);
    }

    @Override
    public Spirit copy() {
        return new Taltecuhtli ();
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
