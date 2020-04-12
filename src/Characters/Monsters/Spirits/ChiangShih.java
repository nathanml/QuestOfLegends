package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class ChiangShih extends Spirit {

    public ChiangShih()
    {
        super("Chiang-Shih",4,700,600,400);
        piece = new Piece (name, "C", false);
    }

    @Override
    public Spirit copy() {
        return new ChiangShih ();
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
