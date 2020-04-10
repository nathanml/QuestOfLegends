package Main;

import Characters.Heroes.Hero;

public class Wallet {
    private int money;
    private Hero hero;

    //Constructor
    public Wallet(int m, Hero h)
    {
        money = m;
        hero = h;
    }

    public int getMoney()
    {
        return money;
    }

    public void addMoney(int amount){
        money += amount;
    }

    public void spendMoney(int amount){
        money -= amount;
    }

    public void printWallet() {
        System.out.println(hero.getName () + ", you currently have " + money + " in your wallet");
    }

    public void loseMoney() {
        //Method for losing half of money after a loss
        money = money/2;
        printWallet ();
    }

    public static void main(String[] args){

    }
}
