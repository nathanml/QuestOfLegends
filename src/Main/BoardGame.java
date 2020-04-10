package Main;

import Tiles.*;

public abstract class BoardGame implements Playable {
    /*Abstract class for all board games. All games will have a name and a playGame method */
    String name;    //Name
    Team currentTeam;   //Main.Team who's turn it is
    Player currentPlayer;   //Main.Player who's turn it is
    Piece[] gamePieces; //List of all pieces used for game
    Tiles.Board board;        //Game board
    int numTurns;       //Counts the how many turns there have been in a game
    boolean isOver;     //Keeps track of when game is over

    public BoardGame(){
        /*Constructor for board game*/
    }

    public abstract void initializePieces();    //Abstract method for initializing pieces

    public static void main(String[] args) {
        // write your code here
    }
}
