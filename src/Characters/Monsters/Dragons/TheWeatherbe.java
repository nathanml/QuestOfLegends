package Characters.Monsters.Dragons;

import Characters.Character;

public class TheWeatherbe extends Dragon{

    public TheWeatherbe()
    {
        super("The Weatherbe", 8,800,900,80);
    }

    public static void main(String[] args)
    {

    }

    @Override
    public Dragon copy() {
        return new TheWeatherbe ();
    }

    @Override
    public void attack(Character c) {

    }

    @Override
    public void loseFight() {

    }

    @Override
    public void winFight() {

    }

    @Override
    public void displayStats() {

    }
}
