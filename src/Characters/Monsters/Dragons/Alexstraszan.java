package Characters.Monsters.Dragons;

import Characters.Character;

public class Alexstraszan extends Dragon {

    public Alexstraszan()
    {
        super("Alexstraszan",10,1000,9000,55);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new Alexstraszan ();
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
