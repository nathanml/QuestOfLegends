package Characters.Monsters.Dragons;

import Characters.Character;

public class Chrysophylax extends Dragon{

    public Chrysophylax()
    {
        super("Chrysophylax", 2,200,500,20);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new Chrysophylax ();
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
