package Tiles;

import Main.Piece;

public class InaccessibleTile extends Tile{

    public InaccessibleTile()
    {
        super ();
        name = "Inaccessible Tile";
        val = 'I';
    }

    @Override
    public String getTile()
    {
        return("|XXXXXXX|");
    }

    public static void main(String[] args)
    {

    }
}
