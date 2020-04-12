package Tiles;

import Characters.Heroes.Hero;
import Characters.Monsters.Monster;
import Main.*;

public class Board {
    private int numRows;    //Number of rows in board
    private int numColumns; //Number of columns in board
    private Tile[][] tiles; //Array of tiles for holding pieces

    public Board(int w, int h){
        /* Method for initializing a board to specified dimensions*/
        numRows = h;
        numColumns = w;
        tiles = new Tile[w][h];
        for(int i=0; i<numRows; i++)
        {
            for(int j=0; j<numColumns; j++)
            {
                if(j==2 || j==5)
                {
                    tiles[i][j] = new InaccessibleTile ();
                }
                else if(i==0 || i==numColumns-1)
                {
                    tiles[i][j] = new NexusTile ();
                }
                else
                {
                    double p = Math.random () * 4;

                    if(p < 1)
                    {
                        tiles[i][j] = new PlainTile ();
                    }
                    else if(p >= 1 && p < 2)
                    {
                        tiles[i][j] = new BushTile ();
                    }
                    else if(p >= 2 && p < 3)
                    {
                        tiles[i][j] = new KuoloTile ();
                    }
                    else {
                        tiles[i][j] = new CaveTile ();
                    }
                }
            }
        }
    }

    public void printBoard(){
        /* Method for displaying board to user */
        System.out.println("------------------------------------------------------------------------");
        System.out.println ("                        MONSTERS NEXUS                                 ");
        for(int i = 0; i < numRows; i++){
            System.out.println("------------------------------------------------------------------------");
            String toPrint = "";
            for(int j=0; j < numColumns; j++){
                toPrint += tiles[i][j].getTile();
            }
            System.out.println(toPrint);
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println ("                        HEROES NEXUS                                 ");
        System.out.println("------------------------------------------------------------------------");
    }

    public Tile tileAt(int row, int col) {
        /*Method for returning specified tile*/
        return tiles[row][col];
    }

    public void setHeroTile(int row, int col, Hero h){
        /* Method for putting piece on tile*/
        tiles[row][col].setHeroTile (h);
    }

    public void setMonsterTile(int row, int col, Monster m){
        tiles[row][col].setMonsterTile (m);
    }

    public boolean isValid(int row, int col){
        /*Method for checking if move is valid in game*/
        if(row >= numRows || row < 0 || col >= numColumns || col < 0)
            return false;
        if(isAccessible(row,col))
            return true;
        else return false;
    }

    //Method for checking if tile is NA tile
    public boolean isAccessible(int row, int col) {
        return (tileAt (row,col).val != 'I');
    }

/*
    public void removeTile(int currentRow, int currentCol) {
        tiles[currentRow][currentCol] = new Tile (new Piece ("Common", " "));
    }
    */
    public static void main(String[] args) {
        // write your code here
    }
}
