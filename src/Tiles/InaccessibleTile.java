package Tiles;

import Characters.Heroes.Hero;
import Main.Piece;

public class InaccessibleTile extends Tile{

    public InaccessibleTile()
    {
        super ();
        name = "Inaccessible Tile";
        val = 'I';
        hasMonsterPiece = false;
        hasHeroPiece = false;
    }

    @Override
    public String getTile()
    {
        return("|XXXXXXX|");
    }

    @Override
    public void performAction(Hero h) {

    }

    public static void main(String[] args)
    {

    }
}
