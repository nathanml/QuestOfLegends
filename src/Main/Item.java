package Main;

import Characters.Heroes.Hero;

public class Item implements Sellable{
    protected String name;
    protected int price;
    protected int minLevel;

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public void buyItem(Hero h) {

    }

    @Override
    public void sellItem(Hero h) {

    }

    public int getLevel(){
        return minLevel;
    }

    public static void main(String[] args)
    {

    }
}