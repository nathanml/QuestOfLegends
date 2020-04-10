package Main;

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

    public int getLevel(){
        return minLevel;
    }

    public static void main(String[] args)
    {

    }
}