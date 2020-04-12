package Characters.Monsters.Dragons;

import Characters.Character;

public class Natsunomeryu extends Dragon{

    public Natsunomeryu()
    {
        super("Natsunomeryu",1,100,200,10);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new Natsunomeryu ();
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
