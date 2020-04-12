package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class Kiaransalee extends Exoskeleton {

    public Kiaransalee()
    {
        super("Kiaransalee",8,850,950,85);
    }

    @Override
    public Exoskeleton copy() {
        return new Kiaransalee ();
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
