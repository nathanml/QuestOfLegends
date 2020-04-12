package Characters.Heroes.Warriors;

public class Gaerdal_Ironhand extends Warrior {

    public Gaerdal_Ironhand()
    {
        super("Gaerdal Ironhand",100,700,500,600,1354,7);
    }

    @Override
    public Warrior copy() {
        return new Gaerdal_Ironhand ();
    }

    public static void main(String[] args)
    {

    }
}
