package Characters.Monsters.Exoskeletons;

import Characters.Character;
import Main.Piece;

public class StShargaas extends Exoskeleton {

    public StShargaas()
    {
        super("St-Shargaas",5,550,650,55);
    }

    @Override
    public Exoskeleton copy() {
        return new StShargaas ();
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
