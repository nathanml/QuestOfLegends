package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class FallenAngel extends Spirit {

    public FallenAngel()
    {
        super("Fallen Angel",5,800,700,50);
        piece = new Piece (name, "F", false);
    }

    @Override
    public Spirit copy() {
        return new FallenAngel();
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
