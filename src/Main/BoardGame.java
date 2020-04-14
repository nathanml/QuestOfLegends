package Main;

import Tiles.*;

public abstract class BoardGame implements Playable {
    /*Abstract class for all board games. All games will have a name and a playGame method */
    public String name;    //Name
    protected Team currentTeam;   //Main.Team who's turn it is
    protected Player currentPlayer;   //Main.Player who's turn it is
    protected Piece[] gamePieces; //List of all pieces used for game
    protected Board board;        //Game board
    protected int numTurns;       //Counts the how many turns there have been in a game
    protected boolean isOver;     //Keeps track of when game is over
    protected String winner;

    public BoardGame(){
        /*Constructor for board game*/
    }

    public abstract void initializePieces();    //Abstract method for initializing pieces

    public static void main(String[] args) {
        // write your code here
    }
}
