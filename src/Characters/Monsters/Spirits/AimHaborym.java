package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class AimHaborym extends Spirit {

    public AimHaborym()
    {
        super("Aim-Haborym",1,450,350,35);
        piece = new Piece (name, "A", false);
    }

    @Override
    public Spirit copy() {
        return new AimHaborym ();
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
