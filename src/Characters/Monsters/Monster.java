package Characters.Monsters;

import Characters.Character;
import Characters.Heroes.Hero;
import Main.Team;
import Tiles.Board;
import Tiles.Tile;

public abstract class Monster extends Character {
    protected int damage;
    protected int defense;
    protected int chance;

    public Monster(String n, int l, int dmg, int def, int dc){
        name = n;
        level = l;
        damage = dmg;
        defense = def;
        chance = dc;
        hp = 1000 * level;
        isAlive = true;
    }

    public void attack(Hero h) {
        //If hero doesn't dodge, inflict damage
        System.out.println(name + " attacked " + h.getName ());
        h.damage(damage * level);
        if(h.isAlive())
        {
            System.out.println(h.getName () + " hp : " + h.getHP ());
        }
    }

    @Override
    public boolean dodge() {
        double p = Math.random ();
        return (p <= (chance/100));
    }

    public void damage(int d){
        if(!dodge())
        {
            if(d > defense)
            {
                int damage = d - defense;
                hp -= damage;
                System.out.println(name + " lost " + damage + " hp");
                if(hp <= 0)
                    faint();
            }
            else System.out.println(name + " defended against the attack");
        }
        else System.out.println(name + " dodged the attack.");
    }

    public void printAttributes()
    {
        System.out.println(name + " :");
        System.out.println ("HP : " + hp);
        System.out.println("Damage : " + damage);
        System.out.println("Defense : " + defense);
        System.out.println("Dodge Chance : " + chance);
    }

    public void loseDefense() {
        defense *= 0.9;
    }

    public void loseDamage(){
        damage *= 0.9;
    }

    public void loseChance() {
        chance *= 0.9;
    }

    public int getDefense() {
        return defense;
    }

    public void move(Board board, Team heroes)
    {
        boolean notOver = true;
        while(notOver)
        {
            Tile currentTile = board.tileAt (currentRow,currentCol);
            Tile sideTile;
            if(board.isValid (currentRow, currentCol + 1))
            {
                sideTile = board.tileAt (currentRow, currentCol+1);
            }
            else
            {
                sideTile = board.tileAt (currentRow, currentCol-1);
            }
            Tile frontTile =  board.tileAt (currentRow + 1, currentCol);

            if(!(currentTile.hasHeroPiece ||  sideTile.hasHeroPiece || frontTile.hasHeroPiece))
            {
                double p = Math.random () * 2;
                if(p<1) {
                    //Move forward
                    board.tileAt (currentRow,currentCol).removeMonster ();
                    currentRow += 1;
                    board.setMonsterTile (currentRow, currentCol, this);
                    board.printBoard ();
                    notOver = false;
                }
                else{
                    if(board.isValid (currentRow,currentCol+1))
                    {
                        board.tileAt (currentRow,currentCol).removeMonster ();
                        currentCol+=1;
                        board.setMonsterTile (currentRow, currentCol, this);
                        board.printBoard ();
                        notOver = false;
                    }
                    else{
                        board.tileAt (currentRow,currentCol).removeMonster ();
                        currentCol-=1;
                        board.setMonsterTile (currentRow, currentCol, this);
                        board.printBoard ();
                        notOver = false;
                    }
                }
            }
            else
            {
                for(int i=0; i<heroes.getSize (); i++)
                {
                    Hero currentHero = (Hero) heroes.getCharacter (i);
                    if(board.tileAt (currentHero.currentRow, currentHero.currentCol) == currentTile ||
                            board.tileAt (currentHero.currentRow, currentHero.currentCol) == sideTile ||
                            board.tileAt (currentHero.currentRow, currentHero.currentCol) == frontTile)
                    {
                        attack (currentHero);
                        if(!currentHero.isAlive ())
                        {
                            board.tileAt (currentHero.currentRow, currentHero.currentCol).removeHero ();
                        }
                        board.printBoard ();
                        notOver = false;
                    }
                }
            }
        }

    }

    public void setTile(Board board, int row, int col)
    {
        if(board.isValid (row,col))
        {
            currentRow = row;
            currentCol = col;
            board.setMonsterTile (row,col,this);
        }
        else System.out.println("Not a valid tile");
    }

    public static void main(String[] args){

    }
}
