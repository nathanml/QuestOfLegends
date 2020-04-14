package Tiles;

import Characters.Heroes.Hero;
import Main.Piece;

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
