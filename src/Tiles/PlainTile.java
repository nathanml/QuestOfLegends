package Tiles;

import Characters.Heroes.Hero;

public class PlainTile extends Tile {

    public PlainTile()
    {
        super ();
        name = "Plain Tile";
        val = ' ';
    }

    @Override
    public void performAction(Hero h) {

    }

    public static void main(String[] args)
    {

    }
}
