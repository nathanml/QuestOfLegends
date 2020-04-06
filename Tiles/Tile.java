package Tiles;

import Main.*;

public class Tile {

    public Piece currentOccupant;   //Stores piece currently on tile
    public boolean hasHeroPiece;    //Stores if the hero's piece is currently on tyle

    public Tile(Piece p)
    {
        /* Constructor method for tile*/
        currentOccupant = p;
        if(p.getVal ().equals ("X"))
            hasHeroPiece = true;
        else hasHeroPiece = false;
    }

    public String getTile()
    {
        /* Obtains string representation of tile
        *  Useful for printing board
        */
        if(hasHeroPiece && currentOccupant.getVal ().equals ("M"))
            return ("| X " + currentOccupant.getVal () + "   |");
        else return("|   " + currentOccupant.getVal () + "   |");
    }

    public static void main(String[] args) {
        // write your code here
    }
}
