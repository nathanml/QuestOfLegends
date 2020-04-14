package Tiles;

import Characters.Heroes.Hero;

public class BushTile extends Tile{

    public BushTile() {
        super ();
        name = "Bush Tile";
        val = 'B';
    }

    @Override
    public void performAction(Hero currentHero) {
        int increase = currentHero.getDexterity ()/10;
        currentHero.increaseDexterity (increase);
        System.out.println(currentHero.getName () + ", your dexterity is now " + currentHero.getDexterity ());
    }

    public static void main(String[] args)
    {

    }
}
