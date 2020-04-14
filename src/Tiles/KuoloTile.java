package Tiles;

import Characters.Heroes.Hero;

public class KuoloTile extends Tile {
    public KuoloTile() {
        super ();
        name = "Kuolo Tile";
        val = 'K';
    }

    @Override
    public void performAction(Hero h) {
        int increase = h.getStrength ()/10;
        h.increaseStrength (increase);
        System.out.println(h.getName () + ", your strength is now " + h.getStrength ());
    }

    public static void main(String[] args)
    {

    }
}
