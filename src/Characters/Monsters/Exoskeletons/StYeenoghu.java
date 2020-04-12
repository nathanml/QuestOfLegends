package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class StYeenoghu extends Exoskeleton {

    public StYeenoghu()
    {
        super("St Yeenoghu",9,950,850,90);
    }

    @Override
    public Exoskeleton copy() {
        return new StYeenoghu ();
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
