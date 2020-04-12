package Characters.Heroes.Warriors;

public class Muamman_Duathall extends Warrior {

    public Muamman_Duathall()
    {
        super("Muamman Duathall",300,900,500,750,2546,6);
    }

    @Override
    public Warrior copy() {
        return new Muamman_Duathall ();
    }

    public static void main(String[] args)
    {

    }
}
