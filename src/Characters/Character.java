package Characters;

import Main.*;
import Tiles.Board;

public abstract class Character implements Fightable {
    public String name;
    protected int level;
    public int currentRow;
    public int currentCol;
    protected int hp = 100*level;
    protected boolean isAlive;
    public Piece piece;
    protected int startLane;

    public void setStartLane(int i)
    {
        startLane = i;
    }

    public int getStartLane()
    {
        return startLane;
    }

    public String getName()
    {
        return name;
    }

    public int getHP()
    {
        return hp;
    }

    public abstract void damage(int d);

    public int getLevel()
    {
        return level;
    }

    public void faint(){
        isAlive = false;
        System.out.println(name + " has fainted");
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public abstract boolean dodge();

    public abstract void printAttributes();

    public abstract void move(Board b, Team t);

    public static void main(String[] args)
    {

    }

    public abstract void setTile(Board board, int row, int col);
}
