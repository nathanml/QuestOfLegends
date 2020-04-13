package Main;

import Characters.Character;
import Characters.Heroes.Hero;
import Characters.Monsters.Monster;
import Tiles.*;
import Characters.Heroes.Paladins.Garl_Glittergold;
import Characters.Heroes.Paladins.Paladin;
import Characters.Heroes.Paladins.Sehanine_Moonbow;
import Characters.Heroes.Paladins.Solonor_Thelandira;
import Characters.Heroes.Sorcerers.Rillifane_Rallathil;
import Characters.Heroes.Sorcerers.Segojan_Earthcaller;
import Characters.Heroes.Sorcerers.Skoraeus_Stonebones;
import Characters.Heroes.Sorcerers.Sorcerer;
import Characters.Heroes.Warriors.Flandal_Steelskin;
import Characters.Heroes.Warriors.Gaerdal_Ironhand;
import Characters.Heroes.Warriors.Muamman_Duathall;
import Characters.Heroes.Warriors.Warrior;
import Characters.Monsters.Dragons.*;
import Characters.Monsters.Exoskeletons.*;
import Characters.Monsters.Spirits.*;

import java.util.Scanner;

public class Quest extends BoardGame implements Playable{
    private static Scanner input;
    private Warrior[] warriors;
    private Sorcerer[] sorcerers;
    private Paladin[] paladins;
    private Dragon[] dragons;
    private Spirit[] spirits;
    private Exoskeleton[] exoskeletons;
    private Team<Monster> monsters;

    public Quest(){
        //Constructor for a quest
        input = new Scanner (System.in);
        name = "The Quest of Legends";
        numTurns = 0;
        board = new Board (8, 8);   //Creates 8x8 game board
        printInstructions ();   //Prints instructions to player
        generateHeroes ();
        generateMonsters ();
        generateTeams ();       //User creates team of heroes
        initializePieces ();    //Initializes board piecess
        setStartTiles();         //Initializes start tile
        board.printBoard();     //print board
    }

    public static void printInstructions(){
        //Method for printing instructions of game
        System.out.println();
    }

    @Override
    public void initializePieces() {
        //Creates 3 game pieces: 1 for markets, 1 for Non-Accessible tiles, and one for the player's piece
        gamePieces = new Piece[6];
        gamePieces[0] = monsters.getCharacter (0).piece;
        gamePieces[1] = monsters.getCharacter (1).piece;
        gamePieces[2] = monsters.getCharacter (2).piece;
        gamePieces[3] = currentPlayer.heroes.getCharacter (0).piece;
        gamePieces[4] = currentPlayer.heroes.getCharacter (1).piece;
        gamePieces[5] = currentPlayer.heroes.getCharacter (2).piece;
    }

    private void generateHeroes() {
        //Method for generating lists of all heroes, warriors, and sorcerers
        generateWarriors();
        generateSorcerers();
        generatePaladins();
    }

    /*Helper Methods for generateHeroes()*/

    public void generateWarriors()
    {
        warriors = new Warrior[3];
        warriors[0] = new Gaerdal_Ironhand ();
        warriors[1] = new Muamman_Duathall ();
        warriors[2] = new Flandal_Steelskin ();
    }

    public void generateSorcerers(){
        sorcerers = new Sorcerer[3];
        sorcerers[0] = new Rillifane_Rallathil ();
        sorcerers[1] = new Segojan_Earthcaller ();
        sorcerers[2] = new Skoraeus_Stonebones ();
    }

    public void generatePaladins(){
        paladins = new Paladin[3];
        paladins[0] = new Solonor_Thelandira ();
        paladins[1] = new Sehanine_Moonbow ();
        paladins[2] = new Garl_Glittergold ();
    }

    @Override
    public void generateTeams() {
        //Method for generating the player's team

        //Prompt user for size of the team
        int size=3;
        currentPlayer = new Player ("Player", size);

        //Create the team, and add the desired heroes to the team

        currentTeam = new Team ("Heroes", size);

        //Prints all heroes for user
        System.out.println("Choose your Heroes:");

        System.out.println("1. WARRIORS");
        System.out.println("--------");
        for(int i=0; i<3; i++)
        {
            warriors[i].printHero ();
        }

        System.out.println("2. SORCERERS");
        System.out.println("---------");
        for(int i=0; i<3; i++)
        {
            sorcerers[i].printHero ();
        }

        System.out.println("3. PALADINS");
        System.out.println("---------");
        for(int i=0; i<3; i++)
        {
            paladins[i].printHero ();
        }

        while (size > 0)
        {
            //Obtains user input and adds desired hero to team
            System.out.println("Enter the name of the hero you want on your team: ");
            String inp = input.nextLine ();
            if(inp.equals (""))
                inp = input.nextLine ();
            for(int i=0; i<3;i++)
            {
                if(warriors[i].getName ().toLowerCase ().equals (inp.toLowerCase ()))
                {
                    Warrior copy = warriors[i].copy();
                    copy.setTile (board,7, (size-1)*3);
                    copy.setStartLane (size-1);
                    currentPlayer.heroes.add (copy);
                    System.out.println(copy.getName () + " has joined your team");
                    size -= 1;
                }

                else if(sorcerers[i].getName ().toLowerCase ().equals (inp.toLowerCase ()))
                {
                    Sorcerer copy = sorcerers[i].copy();
                    copy.setTile (board,7,(size-1)*3);
                    copy.setStartLane (size-1);
                    currentPlayer.heroes.add (copy);
                    System.out.println(sorcerers[i].getName () + " has joined your team");
                    size -= 1;
                }

                else if(paladins[i].getName ().toLowerCase ().equals (inp.toLowerCase ()))
                {
                    Paladin copy = paladins[i].copy();
                    copy.setTile (board,7,(size-1)*3);
                    copy.setStartLane (size-1);
                    currentPlayer.heroes.add (copy);
                    System.out.println(paladins[i].getName () + " has joined your team");
                    size -= 1;
                }
            }
        }

        //Method for creating team of monsters
        size = 3;
        monsters = new Team<Monster> ("Monsters", size);

        for(int i=0; i<size; i++)
        {
            //Randomly assign correct level dragon, exoskeleton, or spirit
            int x = (int) (Math.random () * 3);
            if(x == 1)
            {
                Dragon copy = dragons[currentPlayer.heroes.getCharacter (i).getLevel ()-1].copy ();
                copy.setTile (board,0,(size-1)*3);
                copy.setStartLane (size-1);
                monsters.add (copy);
            }
            else if(x==2)
            {
                Exoskeleton copy = exoskeletons[currentPlayer.heroes.getCharacter (i).getLevel ()-1].copy ();
                copy.setTile (board,0,(size-1)*3);
                monsters.add(copy);
            }
            else {
                Spirit copy = spirits[currentPlayer.heroes.getCharacter (i).getLevel ()-1].copy ();
                copy.setTile (board,0,(size-1)*3);
                monsters.add(copy);
            }
            monsters.getCharacter (i).setTile (board, 0, i*3);
        }
    }

    private void generateMonsters() {
        createDragons();
        createSpirits();
        createExoskeletons();
    }

    private void createDragons() {
        dragons = new Dragon[10];
        dragons[0] = new Natsunomeryu ();
        dragons[1] = new Chrysophylax ();
        dragons[2] = new Desghidorrah ();
        dragons[3] = new BunsenBurner ();
        dragons[4] = new KasEthelinh ();
        dragons[5] = new Phaarthurnax ();
        dragons[6] = new TheScaleless ();
        dragons[7] = new TheWeatherbe ();
        dragons[8] = new DMaleficent ();
        dragons[9] = new Alexstraszan ();
    }
    private void createExoskeletons() {
        exoskeletons = new Exoskeleton[10];
        exoskeletons[0] = new BigBadWolf ();
        exoskeletons[1] = new WickedWitch ();
        exoskeletons[2] = new Brandobaris ();
        exoskeletons[3] = new Aasterinian ();
        exoskeletons[4] = new StShargaas ();
        exoskeletons[5] = new Chronepsish ();
        exoskeletons[6] = new Cyrrollalee ();
        exoskeletons[7] = new Kiaransalee ();
        exoskeletons[8] = new StYeenoghu ();
        exoskeletons[9] = new Merrshaullk ();
    }

    private void createSpirits() {
        spirits = new Spirit[10];
        spirits[0] = new AimHaborym ();
        spirits[1] = new Andrealphus ();
        spirits[2] = new Andromalius ();
        spirits[3] = new ChiangShih ();
        spirits[4] = new FallenAngel ();
        spirits[5] = new Ereshkigall ();
        spirits[6] = new Melchiresas ();
        spirits[7] = new Jormunngand ();
        spirits[8] = new Rakkshasass ();
        spirits[9] = new Taltecuhtli ();
    }

    //Method for setting start tile of the game
    //Game will always start with heroes on tile 1,1
    private void setStartTiles() {
        for(int i=0; i < 3; i++)
        {
            Monster currentMonster = (Monster) monsters.getCharacter (i);
            board.setMonsterTile (0, i*3, currentMonster);
        }
    }

    @Override
    public void playGame() {
        //Method for playing the quest

        while (!isOver) {

            if(numTurns != 0)
            {
                for(int i=0; i<3; i++)
                {
                    Hero current = (Hero) currentPlayer.heroes.getCharacter (i);
                    int mana = current.getMana ();
                    int hp = current.getHP ();
                    int increase = mana/10;
                    current.increaseMana (increase);
                    increase = hp/10;
                    current.increaseHP (increase);
                }
            }
            //Every 8 rounds
            if (numTurns % 8 == 0 && numTurns != 0) {
                for (int i = 0; i < 3; i++) {
                    //Randomly assign correct level dragon, exoskeleton, or spirit
                    int x = (int) (Math.random () * 3);
                    if (x == 1) {
                        Dragon copy = dragons[currentPlayer.heroes.getCharacter (i).getLevel () - 1].copy ();
                        copy.setTile (board, 0, copy.getStartLane () * 3);
                        monsters.add (copy);
                    } else if (x == 2) {
                        Exoskeleton copy = exoskeletons[currentPlayer.heroes.getCharacter (i).getLevel () - 1].copy ();
                        copy.setTile (board, 0, copy.getStartLane () * 3);
                        monsters.add (copy);
                    } else {
                        Spirit copy = spirits[currentPlayer.heroes.getCharacter (i).getLevel () - 1].copy ();
                        copy.setTile (board, 0, copy.getStartLane () * 3);
                        monsters.add (copy);
                    }
                    monsters.getCharacter (i).setTile (board, 0, i * 3);
                }
            }
                //Monsters move first
                for (int i = 0; i < monsters.getSize (); i++) {
                    monsters.changeCurrentCharacter (i);
                    Monster currentMonster = (Monster) monsters.getCurrentCharacter ();
                    System.out.println (currentMonster.getName () + " moves");
                    currentMonster.move (board, currentPlayer.heroes);
                    checkWinner ();

                    //Hero respawns if dead
                    for (int x = 0; x < 3; x++) {
                        if (!currentPlayer.heroes.getCharacter (x).isAlive ()) {
                            Hero currentHero = (Hero) currentPlayer.heroes.getCharacter (x);

                            for (int j = 0; j < 3; j++) {
                                if (warriors[j].getName ().toLowerCase ().equals (currentHero.getName ().toLowerCase ())) {
                                    Warrior copy = warriors[j].copy ();
                                    copy.loseMana (copy.getMana ()/2);
                                    copy.loseHP(copy.getHP ()/2);
                                    copy.setTile (board, 7, currentHero.getStartLane () * 3);
                                    currentPlayer.heroes.characters.add (j,copy);
                                } else if (sorcerers[j].getName ().toLowerCase ().equals (currentHero.getName ().toLowerCase ())) {
                                    Sorcerer copy = sorcerers[j].copy ();
                                    copy.setTile (board, 7, currentHero.getStartLane () * 3);
                                    currentPlayer.heroes.characters.add (j,copy);
                                } else if (paladins[j].getName ().toLowerCase ().equals (currentHero.getName ().toLowerCase ())) {
                                    Paladin copy = paladins[i].copy ();
                                    copy.setTile (board, 7, currentHero.getStartLane () * 3);
                                    currentPlayer.heroes.characters.add (j,copy);
                                }
                            }
                        }
                    }
                }

                //Player moves next
                currentPlayer.move (board, monsters);
                for(int x = 0; x < 3; x++)
                {
                    Monster currentMonster = (Monster) monsters.getCharacter (x);
                    if(!currentMonster.isAlive ())
                    {
                        board.tileAt (currentMonster.currentRow,currentMonster.currentCol).removeMonster ();
                    }
                }
                checkWinner ();
                numTurns += 1;
        }

        System.out.println (winner + " has won the game. Would you like to play another game? [Y/N]");
        String in = input.next();
        while(!(in.equals ("Y") || in.equals ("y") || in.equals ("N") || in.equals ("n")))
        {
            System.out.println("Invalid input. Would you like to play another game?");
            in = input.next ();
        }
        if(in.equals ("Y") || in.equals ("y"))
        {
            Quest q = new Quest();
            q.playGame ();
        }
        else {
            System.out.println("Goodbye.");
            System.exit(0);
        }
    }

    private void checkWinner() {
        for(int i=0; i<3; i++)
        {
            if(monsters.getCharacter (i).currentRow == 7)
            {
                winner = monsters.getName ();
                isOver = true;
            }
            else if(currentPlayer.heroes.getCharacter (i).currentRow == 0)
            {
                winner = currentPlayer.heroes.getName ();
                isOver = true;
            }
        }
    }

    public static void main (String[] args){

    }
}