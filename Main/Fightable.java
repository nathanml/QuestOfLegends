package Main;

import Characters.Character;

public interface Fightable {
    /*
    *   Interface holds methods for all classes that can fight (heroes, monsters, teams)
    * */

    public void damage(int d);

    public void attack(Character c);

    public boolean dodge();

    public void loseFight();

    public void winFight();

    public void displayStats();
}
