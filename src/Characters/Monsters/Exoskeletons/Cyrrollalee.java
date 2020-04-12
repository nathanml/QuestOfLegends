package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class Cyrrollalee extends Exoskeleton {

    public Cyrrollalee()
    {
        super("Cyrrollalee",7,700,800,75);
    }

    @Override
    public Exoskeleton copy() {
        return new Cyrrollalee ();
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
