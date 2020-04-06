package Main;

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

import java.util.Scanner;

public class Quest extends BoardGame implements Playable{
    private static Scanner input;
    private Warrior[] warriors;
    private Sorcerer[] sorcerers;
    private Paladin[] paladins;

    public Quest(){
        //Constructor for a quest
        input = new Scanner (System.in);
        name = "The Quest";
        numTurns = 0;
        board = new Board (8, 8);   //Creates 8x8 game board
        printInstructions ();   //Prints instructions to player
        initializePieces ();    //Initializes board pieces
        generateHeroes();       //Creates all game heroes
        generateTeams ();       //User creates team of heroes
        initializeMarkets();    //Markets placed on board
        initializeNullSpace();  //Null spaces placed on board
        setStartTile();         //Initializes start tile
        board.printBoard();     //print board
    }

    public static void printInstructions(){
        //Method for printing instructions of game
        System.out.println("Welcome to The Quest, a magical game full of spells, heroes, and monsters!\n" +
                "--------------------------------------------------------------------------\n" +
                "THE WORLD OF PLAY\n" +
                "The world of play is an 8x8 board. Each tile of the board either has a market \n" +
                "(denoted by M), is non-accessible (denoted by N), or is a common tile (in which case it is empty). \n" +
                "Your team will be denoted by the X on the board. You can navigate the board with the following commands:\n" +
                "       W/w: Move up \n" +
                "       A/a: Move left \n" +
                "       S/s: Move down \n" +
                "       D/d: Move right \n" +
                "       Q/q: Quit game \n" +
                "       I/i: Check current hero's inventory\n" +
                "You can also type instructions to view the instructions of the game. \n" +
                "\n" +
                "You can only move to common tiles and markets. Your team will always start on the tile 1,1, right next to the\n" +
                "Grand Market.\n" +
                "\n" +
                "--------------------------------------------------------------------------\n" +
                "THE MARKET\n" +
                "At markets you can buy weapons, armors, spells, and potions. The Grand Market is on the tile 1,2, right next \n" +
                "to the heroes starting tile in the game. This market will sell every type of item, however it is the only market that will.\n" +
                "All other markets will only buy and sell one type of item. The 6 types of markets are weaponries, armories, potion markets,\n" +
                "fire markets, ice markets, and lightning markets. These markets will also change location and be randomly assigned when the hero\n" +
                "lands on the tile (with the exception of the Grand Market, which is at tile 1,2).\n" +
                "\n" +
                "Weaponries sell weapons, which can be used to attack monsters during fights. Heroes can only hold one weapon at a time, so they must equip a weapon before they can attack with it.\n" +
                "\n" +
                "Armories sell armors, which protect heroes from incoming attacks from monsters.\n" +
                "\n" +
                "Potion markets sell potions, one use items that can increase one of a hero's attributes.\n" +
                "\n" +
                "Fire markets sell fire spells which damage an enemy and reduces that enemy's defense\n" +
                "\n" +
                "Ice markets sell ice spells which damage an enemy and reduces that enemy's damage.\n" +
                "\n" +
                "Lightning markets sell lightning spells which make it harder for an enemy to dodge attacks.\n" +
                "\n" +
                "------------------------------------------------------------------------------\n" +
                "THE HEROES AND MONSTERS\n" +
                "\n" +
                "There are 3 types of heroes: Warriors (favored on strength and agility), Sorcerers (favored on dexterity and agility), and Paladins \n" +
                "(favored on strength and dexterity). All heros have health (hp), magic power (mana), and experience (exp). Mana is required for \n" +
                "casting spells and experience determines when a hero can level up. Hero's strength is the damage they inflict when they attack, dexterity increases damage when casting a spell, and agility increases the chance of dodging an incoming attack.\n" +
                "\n" +
                "When heroes land on a non-market tile, there is a 75% chance that a fight with monsters will be started. The team of monsters will\n" +
                "be randomly formed at the moment of the fight. The three types of monsters are Dragons (higher damage), Exoskeletons (higher defense),\n" +
                "and Spirits (higher dodge chance).\n" +
                "\n" +
                "------------------------------------------------------------------------------\n" +
                "THE FIGHT\n" +
                "\n" +
                "During a fight, the heroes will attack first. Every hero will have a chance to make a move before the monsters attack. During a turn,\n" +
                "each hero can:\n" +
                "\t1. Attack: If the hero is holding a weapon, this will deal a great amout of damage to the monster. If not, the damage will \n" +
                "\t\t\t\tbe determined by the hero's strength.\n" +
                "\t2. Cast Spell: Hero's can cast any spell they have bought at any time during a fight if they have enough mana. \n" +
                "\t3. Drink Potion: A hero can drink a potion during a round of the fight.\n" +
                "\t4. Change weapon\n" +
                "\t5. Change armor\n" +
                "\n" +
                "After the hero's attack the monsters will randomly attack the hero's and the hero's will defend. If a hero or monster faints during\n" +
                "the fight, the fight will continue until the entire team has fainted, at which point that team loses the fight. If the heroes win, they are rewarded with money and experience. If they lose, they regain half of their hp and lose half of their money.");
    }

    @Override
    public void initializePieces() {
        //Creates 3 game pieces: 1 for markets, 1 for Non-Accessible tiles, and one for the player's piece
        gamePieces = new Piece[3];
        gamePieces[0] = new Piece ("Market", "M");
        gamePieces[1] = new Piece ("Heroes", "X");
        gamePieces[2] = new Piece ("NA", "N");
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
        System.out.println("How many heroes would you like on your team? You can have 1-3 heroes:");
        while (!input.hasNextInt ()){
            System.out.println("Please enter a number 1-3: ");
            input.next ();
        }
        int in = input.nextInt ();
        while (in < 1 || in > 3){
            System.out.println("Please enter a number 1-3:");
            in = input.nextInt ();
        }
        currentPlayer = new Player ("Main.Player", in);

        //Create the team, and add the desired heroes to the team

        currentTeam = new Team ("Heroes", in);

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

        while (in > 0)
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
                    currentPlayer.heroes.add (warriors[i]);
                    currentPlayer.heroes.updateHealth ();
                    System.out.println(warriors[i].getName () + " has joined your team");
                    in -= 1;
                }

                else if(sorcerers[i].getName ().toLowerCase ().equals (inp.toLowerCase ()))
                {
                    currentPlayer.heroes.add (sorcerers[i]);
                    currentPlayer.heroes.updateHealth ();
                    System.out.println(sorcerers[i].getName () + " has joined your team");
                    in -= 1;
                }

                else if(paladins[i].getName ().toLowerCase ().equals (inp.toLowerCase ()))
                {
                    currentPlayer.heroes.add (paladins[i]);
                    currentPlayer.heroes.updateHealth ();
                    System.out.println(paladins[i].getName () + " has joined your team");
                    in -= 1;
                }
            }
        }
    }

    //Method for setting start tile of the game
    //Game will always start with heroes on tile 1,1
    private void setStartTile() {
        board.setTile (1,1,gamePieces[1]);
        board.setTile (1,2,gamePieces[0]);
        currentPlayer.currentRow = 1;
        currentPlayer.currentCol = 1;
    }

    private void initializeMarkets() {
        //Method for intializing the markets on the board
        //The board is 8x8 and 20 of the tiles will be Markets
        //The grand market will always be next to the heroes starting tile
        int count = 19;
        while (count > 0)
        {
            int row = (int) (8 * Math.random ());
            int col = (int) (8 * Math.random ());
            row -= 1;
            col -= 1;
            if(board.isValid (row,col))
            {
                board.setTile (row, col, gamePieces[0]);
                count -=1;
            }
        }
    }

    //Method for intitializing null spaces on board
    private void initializeNullSpace()
    {

    }

    @Override
    public void playGame() {
        //Method for playing the quest

        while(!isOver)
        {
            //Main.Player moves piece on the board
            currentPlayer.move(board, gamePieces);

            //If fight, begin fight


            board.printBoard ();

        }
    }

    public static void main(String[] args){

    }
}