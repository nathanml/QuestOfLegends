package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class Aasterinian extends Exoskeleton {

    public Aasterinian()
    {
        super("Aasterinian",4,400,500,75);
    }

    @Override
    public Exoskeleton copy() {
        return new Aasterinian ();
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
