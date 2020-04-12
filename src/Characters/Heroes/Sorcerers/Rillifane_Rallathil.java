package Characters.Heroes.Sorcerers;

public class Rillifane_Rallathil extends Sorcerer {

    public Rillifane_Rallathil()
    {
        super("Rillifane Rallathil",1300,750,450,500,2500,9);
    }

    @Override
    public Sorcerer copy() {
        return new Rillifane_Rallathil ();
    }

    public static void main(String[] args)
    {

    }
}
