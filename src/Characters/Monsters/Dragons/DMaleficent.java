package Characters.Monsters.Dragons;

import Characters.Character;

public class DMaleficent extends Dragon{

    public DMaleficent()
    {
        super("D-Maleficent",8,800,900,80);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new DMaleficent ();
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
