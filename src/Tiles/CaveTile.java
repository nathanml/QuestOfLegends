package Tiles;

import Characters.Heroes.Hero;

public class CaveTile extends Tile {

    public CaveTile() {
        super ();
        name = "Cave Tile";
        val = 'C';
    }

    @Override
    public void performAction(Hero h) {
        int increase = h.getAgility ()/10;
        h.increaseAgility (increase);
        System.out.println(h.getName () + ", your agility is now " + h.getAgility ());
    }

    public static void main(String[] args) {

    }
}
