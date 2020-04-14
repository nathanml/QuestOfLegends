package Tiles;

import Characters.Heroes.Hero;
import Main.Piece;
import Markets.HeroNexus;

public class NexusTile extends Tile {
    public NexusTile() {
        super ();
        name = "Nexus Tile";
        val = 'N';
    }

    @Override
    public void performAction(Hero h) {
        HeroNexus M = new HeroNexus (h);
        M.enter ();
    }

    public static void main(String[] args)
    {

    }
}
