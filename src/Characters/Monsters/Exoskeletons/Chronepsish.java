package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class Chronepsish extends Exoskeleton {

    public Chronepsish()
    {
        super("Chronepsish",6,650,750,60);
    }

    @Override
    public Exoskeleton copy() {
        return new Chronepsish ();
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
