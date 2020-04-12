package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class WickedWitch extends Exoskeleton {

    public WickedWitch()
    {
        super("Wicked Witch",2,250,350,25);
    }

    @Override
    public Exoskeleton copy() {
        return new WickedWitch ();
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
