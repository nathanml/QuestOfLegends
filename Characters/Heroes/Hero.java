package Characters.Heroes;

import Armors.Armor;
import Characters.Monsters.Monster;
import Main.Wallet;
import Potions.Potion;
import Spells.FireSpells.FireSpell;
import Spells.IceSpells.IceSpell;
import Spells.LightningSpells.LightningSpell;
import Weapons.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Hero extends Characters.Character {
    public static Scanner input = new Scanner (System.in);
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
            if(m.isAlive)
                System.out.println(m.getName () + " hp : " + m.getHP ());
        }
        else{
            int weaponDamage = currentWeapon.getDamage ();
            int totalDamage = (strength + weaponDamage) / 2;
            System.out.println (name + " attacked " + m.getName ());
            m.damage (totalDamage);
            if(m.isAlive)
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

    public void move()
    {

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
}