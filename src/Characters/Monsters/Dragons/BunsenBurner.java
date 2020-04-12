package Characters.Monsters.Dragons;

import Characters.Character;

public class BunsenBurner extends Dragon{

    public BunsenBurner()
    {
        super("Bunsen Burner", 4,400,500,45);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new BunsenBurner ();
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
