package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class Brandobaris extends Exoskeleton {

    public Brandobaris()
    {
        super("Brandobaris",3,350,450,30);
    }

    @Override
    public Exoskeleton copy() {
        return new Brandobaris ();
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
