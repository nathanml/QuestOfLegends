package Characters.Heroes.Warriors;

public class Flandal_Steelskin extends Warrior {

    public Flandal_Steelskin()
    {
        super("Flandal Steelskin",200,750,650,700,2500,7);
    }

    @Override
    public Warrior copy() {
        return new Gaerdal_Ironhand ();
    }

    public static void main(String[] args)
    {

    }
}
