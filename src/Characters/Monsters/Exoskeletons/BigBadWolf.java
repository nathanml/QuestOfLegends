package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class BigBadWolf extends Exoskeleton {

    public BigBadWolf()
    {
        super("Big Bad Wolf",1,150,250,15);
    }

    @Override
    public Exoskeleton copy() {
        return new BigBadWolf ();
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
