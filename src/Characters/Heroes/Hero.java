package Characters.Heroes;

import Main.*;
import Armors.Armor;
import Characters.Character;
import Characters.Monsters.Monster;
import Main.Wallet;
import Potions.Potion;
import Spells.FireSpells.FireSpell;
import Spells.IceSpells.IceSpell;
import Spells.LightningSpells.LightningSpell;
import Tiles.Board;
import Tiles.Tile;
import Weapons.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public abstract class Hero extends Character {
    public static Scanner input = new Scanner (in);
    public Piece piece;
    protected int mana;
    public int exp;
    protected int nextLevel;
    public Weapon currentWeapon;
    protected Armor currentArmor;
    protected ArrayList<Weapon> weapons;
    protected ArrayList<Potion> potions;
    protected ArrayList<IceSpell> iceSpells;
    protected ArrayList<FireSpell> fireSpells;
    protected ArrayList<LightningSpell> lightningSpells;
    protected ArrayList<Armor> armors;
    public Wallet wallet;
    protected int strength;
    protected int agility;
    protected int dexterity;

    public Hero(String n, int m, int s, int a, int d, int mon, int x) {
        //Constructor for a hero
        name = n;
        mana = m;
        strength = s;
        agility = a;
        dexterity = d;
        wallet = new Wallet (mon, this);
        exp = x;
        weapons = new ArrayList<Weapon> ();
        potions = new ArrayList<Potion> ();
        iceSpells = new ArrayList<IceSpell> ();
        fireSpells = new ArrayList<FireSpell> ();
        lightningSpells = new ArrayList<LightningSpell> ();
        armors = new ArrayList<Armor> ();
        level = 1;
        hp = 1000 * level;
        nextLevel = 10;
        isAlive = true;
    }

    public void printHero() {
        //Prints hero
        System.out.println (name.toUpperCase ());
        System.out.println ("Mana : " + mana);
        System.out.println ("Strength : " + strength);
        System.out.println ("Agility : " + agility);
        System.out.println ("Starting Money : " + wallet.getMoney ());
        System.out.println ("Starting Experience : " + 7);
    }

    public abstract void levelUp();

    //Returns true when hero is ready to level up
    public boolean checkLevel()
    {
        return (exp >= nextLevel);
    }

    public void checkInventory() {
        //Method for displaying hero's inventory
        //Print wallet
        printWeapons ();
        printPotions ();
        printSpells ();
        printArmors ();
    }

    public void printWeapons() {
        //Display weapons
        System.out.println ("WEAPONS");
        for (int i = 0; i < weapons.size (); i++) {
            System.out.println (i + ". " + weapons.get (i).getName ());
        }
    }

    public void printPotions() {
        //Display Potions
        System.out.println ("POTIONS");
        for (int i = 0; i < potions.size (); i++) {
            System.out.println (i + ". " + potions.get (i).getName ());
        }
    }

    public void printIceSpells()
    {
        System.out.println ("ICE SPELLS");
        for (int i = 0; i < iceSpells.size (); i++) {
            System.out.println (i + ". " + iceSpells.get (i).getName ());
        }
    }

    public void printFireSpells()
    {
        System.out.println ("FIRE SPELLS");
        for (int i = 0; i < fireSpells.size (); i++) {
            System.out.println (i + ". " + fireSpells.get (i).getName ());
        }
    }

    public void printLightningSpells()
    {
        System.out.println ("LIGHTNING SPELLS");
        for (int i = 0; i < lightningSpells.size (); i++) {
            System.out.println (i + ". " + lightningSpells.get (i).getName ());
        }
    }

    public void printSpells() {
        //Display Spells
        printIceSpells ();
        printFireSpells ();
        printLightningSpells ();
    }

    public void printArmors() {
        //Display Armors
        System.out.println ("ARMORS");
        for (int i = 0; i < armors.size (); i++) {
            System.out.println (i + ". " + armors.get (i).getName ());
        }
    }

    //Get hero's dexterity
    public int getDexterity() {
        return dexterity;
    }

    //Get hero's strength
    public int getStrength() {
        return strength;
    }

    //Get hero's agility
    public int getAgility() {
        return agility;
    }

    //Get hero's mana
    public int getMana() {
        return mana;
    }

    //Method for losing mana
    public void loseMana(int x) {
        mana -= x;
    }

    //Add armor to hero's inventory
    public void addArmor(Armor a) {
        armors.add (a);
    }

    //Add potion to hero's inventory
    public void addPotion(Potion p) {
        potions.add (p);
    }

    //Add fire spell to hero's inventory
    public void addFireSpell(FireSpell f) {
        fireSpells.add (f);
    }

    //Add ice spell to hero's inventory
    public void addIceSpell(IceSpell i) {
        iceSpells.add (i);
    }

    //Add lightning spell to hero's inventory
    public void addLightningSpell(LightningSpell l) {
        lightningSpells.add (l);
    }

    //Add weapon to hero's inventory
    public void addWeapon(Weapon w) {
        weapons.add (w);
    }

    //Increases hero strength
    public void increaseStrength(int x) {
        strength += x;
    }

    public void increaseMana(int x) {
        mana += x;
    }

    public void increaseHP(int x) {
        hp += x;
    }

    public void increaseAgility(int x) {
        agility += x;
    }

    public void increaseDexterity(int x) {
        dexterity += x;
    }

    /*
    *   METHODS FOR DURING FIGHTING
    *
    *       1. Attacking
    *       2. Casting Spells
    *       3. Drinking Potions
    *       4. Changing Weapons
    *       5. Changing armor
    * */

    public void attack(Monster m) {
        //Method for attacking a monster
        if (currentWeapon == null) {
            System.out.println (name + " attacked " + m.getName ());
            m.damage (strength / 2);
            if(m.isAlive())
                System.out.println(m.getName () + " hp : " + m.getHP ());
        }
        else{
            int weaponDamage = currentWeapon.getDamage ();
            int totalDamage = (strength + weaponDamage) / 2;
            System.out.println (name + " attacked " + m.getName ());
            m.damage (totalDamage);
            if(m.isAlive())
                System.out.println(m.getName () + " hp : " + m.getHP ());
        }
    }

    //Method for taking in damage
    @Override
    public void damage(int d)
    {
        if(!dodge ())
        {

            //If no armor equipped
            if(currentArmor == null)
            {
                hp -= d;
                System.out.println(name + " lost " + d + " hp");
                if(hp <= 0)
                {
                    faint();
                }
            }

            //With armor
            else
            {
                if(d > currentArmor.getDamageReduction ())
                {
                    int finalDamage = d - currentArmor.getDamageReduction ();
                    hp -= finalDamage;
                    System.out.println(name + " lost " + d + " hp");
                    if(hp <= 0)
                    {
                        faint();
                    }
                }
                else System.out.println (name + " defended against the attack.");
            }
        }
        else System.out.println(name + " dodged the attack.");
    }

    public String getName() {
        //Returns name of character
        return name;
    }

    @Override
    public boolean dodge() {
        //Determines if hero dodges attack
        double p = Math.random ();
        double dodgeChance = agility * 0.02;
        return (p <= dodgeChance / 100);
    }

    @Override
    public void loseFight() {
        //When heroes lose fights they lose half their money
        wallet.loseMoney ();
    }

    public void castSpell(Monster m) {
        System.out.println ("1. Fire Spell");
        System.out.println ("2. Ice Spell");
        System.out.println ("3. Lightning Spell");
        System.out.println ("Enter the number of the type of spell you want to cast: ");
        while (!input.hasNextInt ()) {
            System.out.println ("Invalid input. Please enter a number 1-3");
        }
        int in = input.nextInt ();
        while(in < 1 || in > 3)
        {
            System.out.println("Please enter a number between 1 and 3");
            in = input.nextInt ();
        }
        if(in == 1)
        {
            castFireSpell (m);
        }
        else if(in == 2)
        {
            castIceSpell (m);
        }
        else if(in == 3)
            castLightningSpell (m);
        else{
            System.out.println("Not a valid input. " + name + ", you didn't cast a spell in time.");
        }
    }

    private void castLightningSpell(Monster m) {
        if(lightningSpells.size () == 0)
        {
            System.out.println("You don't have any lightning spells");
        }
        else{
            printLightningSpells ();
            System.out.println ("Enter the number of the spell you would like to cast: ");
            while (!input.hasNextInt ()) {
                System.out.println ("Please enter the number of the spell you'd like to cast:");
                input.next ();
            }
            int in = input.nextInt ();
            while (in < 0 || in > lightningSpells.size ()) {
                System.out.println ("Please enter a valid entry");
                in = input.nextInt ();
            }
            if(mana < lightningSpells.get(in).getMana ())
            {
                System.out.println("You don't have enough mana to cast this spell");
            }
            else lightningSpells.get (in).castSpell (this, m);
        }
    }

    private void castIceSpell(Monster m) {
        if(iceSpells.size () == 0)
        {
            System.out.println("You don't have any ice spells");
        }
        else{
            printIceSpells ();
            System.out.println ("Enter the number of the spell you would like to cast: ");
            while (!input.hasNextInt ()) {
                System.out.println ("Please enter the number of the spell you'd like to cast:");
                input.next ();
            }
            int in = input.nextInt ();
            while (in < 0 || in > iceSpells.size ()) {
                System.out.println ("Please enter a valid entry");
                in = input.nextInt ();
            }
            if(mana < iceSpells.get(in).getMana ())
            {
                System.out.println("You don't have enough mana to cast this spell");
            }
            else iceSpells.get (in).castSpell (this, m);
        }
    }

    private void castFireSpell(Monster m) {
        if(fireSpells.size () == 0)
        {
            System.out.println("You don't have any fire spells");
        }
        else{
            printFireSpells ();
            System.out.println ("Enter the number of the spell you would like to cast: ");
            while (!input.hasNextInt ()) {
                System.out.println ("Please enter the number of the spell you'd like to cast:");
                input.next ();
            }
            int in = input.nextInt ();
            while (in < 0 || in > fireSpells.size ()) {
                System.out.println ("Please enter a valid entry");
                in = input.nextInt ();
            }
            if(mana < fireSpells.get(in).getMana ())
            {
                System.out.println("You don't have enough mana to cast this spell");
            }
            else fireSpells.get (in).castSpell (this, m);
        }
    }

    public void drinkPotion() {
        if(potions.size () == 0)
        {
            System.out.println("You don't have any potions");
        }
        else{
            printPotions ();
            System.out.println ("Enter the number of the potion you would like to drink: ");
            while (!input.hasNextInt ()) {
                System.out.println ("Please enter the number of the potion you'd like to drink:");
                input.next ();
            }
            int in = input.nextInt ();
            while (in < 0 || in > potions.size ()) {
                System.out.println ("Please enter a valid entry");
                in = input.nextInt ();
            }

            //Drink potion
            potions.get (in).usePotion (this);
            potions.remove (in);
        }
    }

    public void changeArmor() {
        if(armors.size () == 0)
        {
            System.out.println("You don't have any armors");
        }
        else {
            printArmors ();
            System.out.println ("Enter the number of the armor you would like to wear: ");
            while (!input.hasNextInt ()) {
                System.out.println ("Please enter the number of the armor you'd like to wear:");
                input.next ();
            }
            int in = input.nextInt ();
            while (in < 0 || in > armors.size ()) {
                System.out.println ("Please enter a valid entry");
                in = input.nextInt ();
            }
            //Equip armor
            currentArmor = armors.get (in);
        }

    }

    public void changeWeapon() {
        printWeapons ();
        System.out.println ("Enter the number of the weapon you would like to equip: ");
        while (!input.hasNextInt ()) {
            System.out.println ("Please enter the number of the weapon you'd like to equip:");
            input.next ();
        }
        int in = input.nextInt ();
        while (in < 0 || in > weapons.size ()) {
            System.out.println ("Please enter a valid entry");
            in = input.nextInt ();
        }

        //Equip weapon
        currentWeapon = weapons.get (in);
    }

    /*
    *   METHODS FOR SELLING ITEMS
    * */


    //Prints out hero's attributes
    @Override
    public void printAttributes()
    {
        System.out.println(name + " :");
        System.out.println("HP : " + hp);
        System.out.println("Mana : " + mana);
        System.out.println("Strength : " + strength);
        System.out.println("Agility : " + agility);
        System.out.println("Dexterity : " + dexterity);
    }

    public void removeLightningSpell(LightningSpell l) {
        for (int i=0; i<lightningSpells.size (); i++)
        {
            if(lightningSpells.get (i)== l)
            {
                lightningSpells.remove (i);
            }
        }
    }

    public void removeIceSpell(IceSpell s) {
        for (int i=0; i<iceSpells.size (); i++)
        {
            if(iceSpells.get (i)== s)
            {
                iceSpells.remove (i);
            }
        }
    }

    public void removeFireSpell(FireSpell f) {
        for (int i=0; i<fireSpells.size (); i++)
        {
            if(fireSpells.get (i )== f)
            {
                fireSpells.remove (i);
                break;
            }
        }
    }

    public void removePotion(Potion p) {
        for (int i=0; i<potions.size (); i++)
        {
            if(potions.get (i) == p)
            {
                potions.remove (i);
            }
        }
    }

    public void removeWeapon(Weapon w) {
        for (int i=0; i<weapons.size (); i++)
        {
            if(w == currentWeapon)
                currentWeapon = null;
            if(weapons.get (i)== w)
            {
                weapons.remove (i);
            }
        }
    }

    public void removeArmor(Armor a) {
        for (int i=0; i<armors.size (); i++)
        {
            if(a == currentArmor)
                currentArmor = null;
            if(armors.get (i)== a)
            {
                armors.remove (i);
            }
        }
    }

    public void move(Board b, Team monsters)
    {
        boolean notOver = true;
        while (notOver)
        {
            System.out.println("W/w: Move up\n" +
                    "    A/a: Move left\n" +
                    "    S/s: Move down\n" +
                    "    D/d: Move right\n" +
                    "    Q/q: Quit game\n" +
                    "    I/i: Check current hero's inventory\n" +
                    "    Instructions: Show the instructions\n" +
                    "    B/B: Return to the Heroes Nexus\n" +
                    "    1: Attack a monster on same or neighboring tile\n" +
                    "    2: Cast a spell\n" +
                    "    3: Drink a potion\n" +
                    "    4: Equip a weapon\n" +
                    "    5: Put on an armor\n" +
                    "    teleport: Teleport to a tile in a different lanen\n" +
                    "    exit: Exit the game");
            System.out.println("Enter your move: ");
            while (!input.hasNext ()){
                System.out.println("Invalid input, please enter your move: ");
            }
            String in = input.next ();

            if(in.equals ("I") || in.equals ("i"))
            {
                System.out.println(name);
                System.out.println("---------");
                printAttributes ();
                checkInventory ();
            }

            else if(in.equals ("b") || in.equals ("b"))
            {
                b.tileAt (currentRow, currentCol).removeHero ();
                b.setHeroTile (7, startLane * 3,this);
                b.printBoard ();
                notOver = true;
            }

            else if(in.toLowerCase ().equals ("instructions"))
            {
                Quest.printInstructions ();
                b.printBoard ();
            }

            else if(in.equals ("A") || in.equals ("a")){
                if(b.isValid (currentRow, currentCol - 1) && !b.tileAt (currentRow, currentCol-1).hasHeroPiece)
                {
                    b.tileAt (currentRow,currentCol).removeHero ();
                    currentCol -= 1;
                    b.setHeroTile (currentRow, currentCol, this);
                    notOver = false;
                }
                else {
                    System.out.println("Not a valid move. Please enter another move.");
                }
            }

            else if(in.equals ("W") || in.equals ("w")){
                if(b.tileAt (currentRow,currentCol).hasMonsterPiece ||
                        (currentCol % 2 == 0 && b.tileAt (currentRow, currentCol+1).hasMonsterPiece)||
                        (currentCol %2 == 1 && b.tileAt (currentRow, currentCol-1).hasMonsterPiece))
                {
                    System.out.println("You cannot move forward until the monster is defeated");
                }
                else if(b.isValid (currentRow-1, currentCol) && !b.tileAt (currentRow-1, currentCol).hasHeroPiece)
                {
                    b.tileAt (currentRow,currentCol).removeHero ();
                    currentRow -= 1;
                    b.setHeroTile (currentRow, currentCol, this);
                    notOver = false;
                }
                else {
                    System.out.println("Not a valid move. Please enter another move.");
                }
            }

            else if(in.equals ("S") || in.equals ("s")){
                if(b.isValid (currentRow+1, currentCol) && !b.tileAt (currentRow+1, currentCol).hasHeroPiece)
                {
                    b.tileAt (currentRow,currentCol).removeHero ();
                    currentRow += 1;
                    b.setHeroTile (currentRow, currentCol, this);
                    notOver = false;
                }
                else {
                    System.out.println("Not a valid move. Please enter another move.");
                }
            }

            else if(in.equals ("D") || in.equals ("d")){
                if(b.isValid (currentRow, currentCol+1) && !b.tileAt (currentRow, currentCol+1).hasHeroPiece)
                {
                    b.tileAt (currentRow,currentCol).removeHero ();
                    currentCol += 1;
                    b.setHeroTile (currentRow, currentCol, this);
                    notOver = false;
                }
                else {
                    System.out.println("Not a valid move. Please enter another move.");
                }
            }

            else if(in.equals ("1"))
            {
                Tile currentTile = b.tileAt (currentRow,currentCol);
                Tile sideTile;
                if(b.isValid (currentRow, currentCol + 1))
                {
                    sideTile = b.tileAt (currentRow, currentCol+1);
                }
                else
                {
                    sideTile = b.tileAt (currentRow, currentCol-1);
                }
                Tile frontTile =  b.tileAt (currentRow + 1, currentCol);

                if(!(currentTile.hasMonsterPiece ||  sideTile.hasMonsterPiece || frontTile.hasMonsterPiece))
                {
                    System.out.println ("No monsters to attack");
                }
                else{
                    for(int i=0; i<monsters.getSize ();i++)
                    {
                        Monster current = (Monster) monsters.getCharacter (i);
                        if(b.tileAt (current.currentRow, current.currentCol) == currentTile ||
                                b.tileAt (current.currentRow, current.currentCol) == sideTile ||
                                b.tileAt (current.currentRow, current.currentCol) == frontTile)
                        {
                            attack (current);
                            b.printBoard ();
                            notOver = false;
                        }
                    }
                }

            }

            else if(in.equals ("2"))
            {
                if(numLightningSpells () == 0 && numIceSpells () == 0 && numFireSpells () == 0)
                {
                    System.out.println("You don't have any spells you can cast at this time");
                }
                else{
                    System.out.println("Which monster would you like to cast your spell against?");
                    monsters.printTeam ();
                    while (!input.hasNextInt ())
                        System.out.println("Please enter the number of the monster you'd like to cast your spell against");
                    int i = input.nextInt ();
                    while (i < 0 || i > monsters.getSize ())
                    {
                        System.out.println("Not a valid input. Which monster would you like to ast your spell against?");
                        monsters.printTeam ();
                        i = input.nextInt ();
                    }
                    Monster m = (Monster) monsters.getCharacter (i);
                    castSpell (m);
                    notOver = false;
                }
            }

            else if(in.equals ("3"))
            {
                if(numPotions () == 0)
                {
                    System.out.println("You don't have any potions you can drink at this time");
                }
                else{
                    drinkPotion ();
                    notOver = false;
                }
            }

            else if(in.equals ("4"))
            {
                if(numWeapons () == 0)
                {
                    System.out.println("You don't have any weapons you can equip at this time");
                }
                else{
                    changeWeapon ();
                    notOver = false;
                }
            }

            else if(in.equals ("5"))
            {
                if(numArmors () == 0)
                {
                    System.out.println("You don't have any armors you can use at this time");
                }
                else{
                    changeArmor ();
                    notOver = false;
                }
            }

            else if(in.toLowerCase ().equals ("teleport"))
            {
                System.out.println("Enter the row you would like to teleport to");
                while (!input.hasNextInt ()) {
                    System.out.println ("Please enter an integer");
                }
                int row = input.nextInt ();
                System.out.println("Enter the column you would like to teleport to");
                while (!input.hasNextInt ())
                    System.out.println("Please enter an integer");
                int col = input.nextInt ();
                Monster laneMonster = null;
                if((col == 0 || col == 1) && currentCol != 0 && currentCol != 1 && b.isValid (row,col) &&
                        !b.tileAt (row,col).hasHeroPiece)
                {
                    laneMonster = (Monster) monsters.getCharacter (0);
                    if(row<=laneMonster.currentRow)
                    {
                        System.out.println("Not a valid tile.");
                    }
                    else {
                        b.tileAt (currentRow,currentCol).removeHero ();
                        currentRow = row;
                        currentCol = col;
                        b.setHeroTile (currentRow, currentCol, this);
                        notOver = false;
                    }
                }
                else if((col == 3 || col == 4) && currentCol != 3 && currentCol != 4 && b.isValid (row,col) && !b.tileAt (row,col).hasHeroPiece)
                {
                    laneMonster = (Monster) monsters.getCharacter (1);
                    if(row<=laneMonster.currentRow)
                    {
                        System.out.println("Not a valid tile.");
                    }
                    else {
                        b.tileAt (currentRow,currentCol).removeHero ();
                        currentRow = row;
                        currentCol = col;
                        b.setHeroTile (currentRow, currentCol, this);
                        notOver = false;
                    }
                }
                else if((col == 6 || col == 7) && currentCol != 6 && currentCol != 7 && b.isValid (row,col) && !b.tileAt (row,col).hasHeroPiece)
                {
                    laneMonster = (Monster) monsters.getCharacter (2);
                    if(row<=laneMonster.currentRow)
                    {
                        System.out.println("Not a valid tile.");
                    }
                    else {
                        b.tileAt (currentRow,currentCol).removeHero ();
                        currentRow = row;
                        currentCol = col;
                        b.setHeroTile (currentRow, currentCol, this);
                        notOver = false;
                    }
                }
                else {
                    System.out.println("Not a valid tile.");
                }
            }

            else if(in.toLowerCase ().equals ("exit"))
            {
                System.out.println("Goodbye");
                System.exit (0);
            }
        }
    }

    public int numWeapons() {
        return weapons.size ();
    }

    public Weapon getWeapon(int i) {
        return weapons.get (i);
    }

    public int numPotions() {
        return potions.size ();
    }

    public Potion getPotion(int i){
        return potions.get (i);
    }

    public int numLightningSpells() {
        return lightningSpells.size ();
    }

    public LightningSpell getLightningSpell(int i){
        return lightningSpells.get (i);
    }

    public int numIceSpells(){
        return iceSpells.size ();
    }

    public IceSpell getIceSpell(int i)
    {
        return iceSpells.get (i);
    }

    public int numFireSpells(){
        return fireSpells.size ();
    }

    public FireSpell getFireSpell(int i)
    {
        return fireSpells.get (i);
    }

    public int numArmors(){
        return armors.size ();
    }

    public Armor getArmor(int i)
    {
        return armors.get(i);
    }

    public boolean canAfford(Item i)
    {
        return (wallet.getMoney () > i.getPrice ());
    }

    public void setTile(Board board, int row, int col)
    {
        if(board.isValid (row,col))
        {
            currentRow = row;
            currentCol = col;
            board.setHeroTile (row,col,this);
        }
        else System.out.println("Not a valid tile");
    }


    public void loseHP(int i) {
        hp -= i;
    }
}