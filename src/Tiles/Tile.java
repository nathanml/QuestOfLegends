package Tiles;

import Characters.Heroes.Hero;
import Characters.Monsters.Monster;
import Main.*;

public class Tile {
    protected String name;
    protected char val;
    public Piece currentHero;   //Stores piece currently on tile
    public Piece currentMonster;
    public boolean hasHeroPiece;    //Stores if the hero's piece is currently on tile
    public boolean hasMonsterPiece; //Stores if the monster's piece is on the tile

    public Tile()
    {
        currentHero = null;
        hasHeroPiece = false;
        currentMonster = null;
        hasMonsterPiece = false;
    }

    public String getTile()
    {
        /* Obtains string representation of tile
        *  Useful for printing board
        */
        if(hasHeroPiece && hasMonsterPiece)
            return ("| " + currentHero.getVal () + " " + val + currentMonster.getVal () + " |");
        else if(hasHeroPiece)
            return ("| " + currentHero.getVal () + " " + val + "   |");
        else if(hasMonsterPiece)
            return ("|   " + val + " " + currentMonster.getVal () + " |");
        else return("|   " + val + "   |");
    }

    public void setHeroTile(Hero h)
    {
        currentHero = h.piece;
        hasHeroPiece = true;
    }

    public void setMonsterTile(Monster m)
    {
        currentMonster = m.piece;
        hasMonsterPiece = true;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
