package Characters.Monsters.Dragons;

import Characters.Character;

public class TheScaleless extends Dragon{

    public TheScaleless()
    {
        super("The Scaleless",7,700,600,75);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new TheScaleless ();
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
