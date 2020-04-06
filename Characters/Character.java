package Characters;

import Main.Fightable;

public abstract class Character implements Fightable {
    protected String name;
    public int level;
    protected int hp = 100*level;
    public boolean isAlive;

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

    public abstract void move();

    public static void main(String[] args)
    {

    }
}
