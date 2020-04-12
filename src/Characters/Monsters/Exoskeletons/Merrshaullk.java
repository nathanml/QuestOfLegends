package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class Merrshaullk extends Exoskeleton {

    public Merrshaullk()
    {
        super("Merrshaullk", 10,1000,900,55);
    }

    @Override
    public Exoskeleton copy() {
        return new Merrshaullk ();
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
