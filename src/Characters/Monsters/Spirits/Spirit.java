package Characters.Monsters.Spirits;

import Characters.Character;
import Characters.Monsters.Monster;
import Main.Piece;
import Tiles.Board;

public abstract class Spirit extends Monster {

    public Spirit(String n, int lev, int dmg, int def, int dc)
    {
        super(n,lev,dmg,def,dc);
        piece = new Piece (name, "S", false);
    }

    public abstract Spirit copy();

    public static void main(String[] args){

    }
}
