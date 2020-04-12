package Characters.Monsters.Dragons;

import Characters.Character;

public class KasEthelinh extends Dragon {

    public KasEthelinh()
    {
        super("Kas Ethelinh",5,600,500,60);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new KasEthelinh ();
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
