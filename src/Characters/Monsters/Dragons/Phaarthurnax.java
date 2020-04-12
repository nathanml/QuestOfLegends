package Characters.Monsters.Dragons;

import Characters.Character;

public class Phaarthurnax extends Dragon {

    public Phaarthurnax()
    {
        super("Phaarthurnax",6,600,700,60);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new Phaarthurnax ();
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
