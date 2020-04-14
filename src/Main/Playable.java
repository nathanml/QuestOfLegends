package Main;

public interface Playable {
    /*Interface used to store methods shared by ALL games that can be played*/

    void generateTeams();    //Method for creating teams

    void playGame();     //Method for playing the game

    void checkWinner();     //Method for checking winner of the game
}
