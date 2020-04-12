package Characters.Monsters.Spirits;

import Characters.Character;
import Main.Piece;

public class Ereshkigall extends Spirit{

    public Ereshkigall()
    {
        super("Ereshkigall",6,950,450,35);
        piece = new Piece (name, "E", false);
    }

    @Override
    public Spirit copy() {
        return new Ereshkigall ();
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
