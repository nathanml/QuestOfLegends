package Main;

import Characters.Heroes.Hero;

public interface Sellable {

    public String getName();

    public int getPrice();

    public void buyItem(Hero h);

    public void sellItem(Hero h);

    public int getLevel();
}
