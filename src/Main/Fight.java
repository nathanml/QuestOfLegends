package Main;

import java.util.Scanner;
import Characters.Monsters.*;
import Characters.Monsters.Dragons.*;
import Characters.Monsters.Spirits.*;
import Characters.Monsters.Exoskeletons.*;
import Characters.Heroes.Hero;

public class Fight {
    public static Scanner input = new Scanner (System.in);
    private Dragon[] Dragons;
    private Spirit[] Spirits;
    private Exoskeleton[] Exoskeletons;
    Team<Hero> heroes;  //Team of heroes
    Team<Monster> monsters; //Team of Monsters
    Team currentTeam;   //Tracks which team is attacking
    boolean isOver;     //Boolean for tracking when fight is over

    //Constructor for a fight
    public Fight(Team<Hero> t){
        createMonsters();
        heroes = t;
        generateMonsters(heroes);
        currentTeam = heroes;
        isOver = false;
    }

    /*
    *   Methods for initializing instances of Monsters
    * */
    private void createMonsters() {
        createDragons();
        createSpirits();
        createExoskeletons();
    }

    private void createDragons() {
        Dragons = new Dragon[10];
        Dragons[0] = new Natsunomeryu ();
        Dragons[1] = new Chrysophylax ();
        Dragons[2] = new Desghidorrah ();
        Dragons[3] = new BunsenBurner ();
        Dragons[4] = new KasEthelinh ();
        Dragons[5] = new Phaarthurnax ();
        Dragons[6] = new TheScaleless ();
        Dragons[7] = new TheWeatherbe ();
        Dragons[8] = new DMaleficent ();
        Dragons[9] = new Alexstraszan ();
    }
    private void createExoskeletons() {
        Exoskeletons = new Exoskeleton[10];
        Exoskeletons[0] = new BigBadWolf ();
        Exoskeletons[1] = new WickedWitch ();
        Exoskeletons[2] = new Brandobaris ();
        Exoskeletons[3] = new Aasterinian ();
        Exoskeletons[4] = new StShargaas ();
        Exoskeletons[5] = new Chronepsish ();
        Exoskeletons[6] = new Cyrrollalee ();
        Exoskeletons[7] = new Kiaransalee ();
        Exoskeletons[8] = new StYeenoghu ();
        Exoskeletons[9] = new Merrshaullk ();
    }

    private void createSpirits() {
        Spirits = new Spirit[10];
        Spirits[0] = new AimHaborym ();
        Spirits[1] = new Andrealphus ();
        Spirits[2] = new Andromalius ();
        Spirits[3] = new ChiangShih ();
        Spirits[4] = new FallenAngel ();
        Spirits[5] = new Ereshkigall ();
        Spirits[6] = new Melchiresas ();
        Spirits[7] = new Jormunngand ();
        Spirits[8] = new Rakkshasass ();
        Spirits[9] = new Taltecuhtli ();
    }

    private void generateMonsters(Team<Hero> heroes) {
        //Method for creating team of monsters
        int size = heroes.getSize ();
        monsters = new Team<Monster> ("Monsters", size);
        monsters.setLevel (heroes.level);

        for(int i=0; i<size; i++)
        {
            //Randomly assign correct level dragon, exoskeleton, or spirit
            int x = (int) (Math.random () * 3);
            if(x == 1)
            {
                monsters.add (Dragons[monsters.level-1]);
                monsters.totalHealth += Dragons[monsters.level-1].getHP ();
            }
            else if(x==2)
            {
                monsters.add(Exoskeletons[monsters.level -1]);
            }
            else {
                monsters.add(Spirits[monsters.level-1]);
            }
        }
    }

    //Method for starting a fight
    public void startFight(){
        //Method to initiate a fight
        System.out.println("You've encountered some monsters!");

        //Hero attacks first
        while(heroes.totalHealth > 0 && monsters.totalHealth > 0)
        {
            //Case 1: Heroes turn
            if(currentTeam == heroes)
            {
                //Loop through each hero, allow them to pick these options
                System.out.println("Monsters total health: " + monsters.totalHealth);
                System.out.println("Heroes total health: " + heroes.totalHealth);
                System.out.println ("HEROES ATTACK");
                int i = heroes.getSize ();
                while (i > 0)
                {
                    heroes.changeCurrentCharacter (i-1);
                    Hero currentHero = (Hero) heroes.getCurrentCharacter ();

                    if(currentHero.isAlive)
                    {
                        currentHero.increaseHP (currentHero.getHP ()/20);
                        currentHero.increaseMana (currentHero.getMana ()/20);
                        System.out.println(currentHero.getName () + ", your turn.");
                        System.out.println("Please enter the number of your move or press 0 to check your inventory:");
                        System.out.println("1. Attack");
                        System.out.println("2. Cast spell");
                        System.out.println("3. Drink potion");
                        System.out.println("4. Change weapon");
                        System.out.println("5. Change armor");

                        //Obtain user input
                        while (!input.hasNextInt ()){
                            System.out.println("Please enter an integer 0-5");
                            input.next();
                        }
                        int in = input.nextInt ();
                        while(in < 0 || in > 5)
                        {
                            System.out.println ("Please enter an integer 0-5");
                            in = input.nextInt ();
                        }

                        //Check inventory
                        if(in == 0)
                        {
                            System.out.println(currentHero.getName ()+ ", here is you inventory:");
                            currentHero.printAttributes ();
                            currentHero.checkInventory ();
                        }

                        /*
                         *   CASE 1: HEROES ATTACK
                         * */
                        if(in == 1)
                        {
                            System.out.println("Which monster would you like to attack?");
                            monsters.printTeam ();
                            while (!input.hasNextInt ())
                                System.out.println("Please enter the number of the monster you'd like to cast your spell against");
                            in = input.nextInt ();
                            while (in < 0 || in > monsters.getSize ())
                            {
                                System.out.println("Not a valid input");
                                in = input.nextInt ();
                            }
                            Monster m = (Monster) monsters.getCharacter (in);
                            //If the monsters don't dodge
                            if(!m.dodge ())
                            {
                                currentHero.attack((m));
                                monsters.updateHealth ();
                                i--;
                            }
                            //Monsters dodge
                            else {
                                System.out.println(m.getName () + " dodged your attack");
                                i--;
                            }
                        }

                        /*
                         * Case 2: Casting a spell
                         * */
                        if(in == 2)
                        {
                            if(currentHero.numLightningSpells () == 0 && currentHero.numIceSpells () == 0 && currentHero.numFireSpells () == 0)
                            {
                                System.out.println("You don't have any spells you can cast at this time");
                            }
                            else{
                                System.out.println("Which monster would you like to cast your spell against?");
                                monsters.printTeam ();
                                while (!input.hasNextInt ())
                                    System.out.println("Please enter the number of the monster you'd like to cast your spell against");
                                in = input.nextInt ();
                                while (in < 0 || in > monsters.getSize ())
                                {
                                    System.out.println("Not a valid input. Which monster would you like to ast your spell against?");
                                    monsters.printTeam ();
                                    in = input.nextInt ();
                                }
                                Monster m = (Monster) monsters.getCharacter (in);
                                currentHero.castSpell (m);
                                monsters.updateHealth ();
                                i--;
                            }
                        }

                        /*
                         * Case 3: Drinking a potion
                         * */
                        if(in == 3)
                        {
                            if(currentHero.numPotions () == 0)
                            {
                                System.out.println("You don't have any potions you can drink at this time");
                            }
                            else{
                                currentHero.drinkPotion ();
                                i--;
                            }
                        }

                        /*
                        * Case 4: Change weapon
                        * */
                        if(in == 4)
                        {
                            if(currentHero.numWeapons () == 0)
                            {
                                System.out.println("You don't have any weapons you can equip at this time");
                            }
                            else{
                                currentHero.changeWeapon ();
                                i--;
                            }
                        }

                        /*
                         * Case 5: Change armor
                         * */
                        if(in == 5)
                        {
                            if(currentHero.numArmors () == 0)
                            {
                                System.out.println("You don't have any armors you can use at this time");
                            }
                            else{
                                currentHero.changeArmor ();
                                i--;
                            }
                        }
                    }

                    else{
                        i--;    //Proceed to next hero
                    }
                }
                currentTeam = monsters;
            }

            else{
                //Current Main.Team is Monsters
                System.out.println("MONSTERS ATTACK!");
                int x = monsters.getSize ();
                while (x > 0)
                {
                    monsters.changeCurrentCharacter (x-1);
                    Monster current = (Monster) monsters.getCurrentCharacter ();

                    //Monsters randomly decide which hero to attack
                    if(current.isAlive)
                    {
                        int h = (int) (Math.random () * heroes.getSize ());
                        Hero hero = (Hero) heroes.getCharacter (h);
                        if(hero.isAlive)
                        {
                            current.attack (hero);
                            heroes.updateHealth ();
                            x--;
                        }
                    }
                    else{
                        monsters.remove(current);
                        x--;
                    }
                }
                currentTeam = heroes;
            }
        }
        //Once all heroes have gone, check if heroes have won, if not, switch to monsters
        if(heroes.totalHealth > 0)
        {
            System.out.println("Congratulations! You've defeated the monsters. Every hero still standing will gain some money and experience.");
            for(int x=0; x<heroes.getSize (); x++)
            {
                heroes.changeCurrentCharacter (x);
                Hero current =  (Hero) heroes.getCurrentCharacter ();

                //If hero did not faint during fight, add money and experience
                if(heroes.getCurrentCharacter ().isAlive())
                {
                    current.wallet.addMoney (150);
                    current.exp += 2;
                    if(current.checkLevel ())
                        current.levelUp ();
                    current.wallet.printWallet ();
                    current.printAttributes ();
                }
                //If hero faints, do nothing
                else{
                    current.increaseHP (500 * current.level);
                }
            }
        }
        else
        {
            System.out.println("Oh no! The monsters have defeated you! All heroes will lose some money.");
            for (int i=0; i<heroes.getSize (); i++)
            {
                heroes.characters.get (i).wallet.loseMoney ();
                heroes.characters.get (i).isAlive = true;
                heroes.characters.get (i).increaseHP (500 * heroes.characters.get (i).getLevel ());
                heroes.updateHealth ();
            }
        }
    }


    public static void main(String[] args){

    }
}
