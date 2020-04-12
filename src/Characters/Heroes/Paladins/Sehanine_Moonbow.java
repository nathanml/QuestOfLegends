package Characters.Heroes.Paladins;

public class Sehanine_Moonbow extends Paladin {

    public Sehanine_Moonbow()
    {
        super("Sehanine Moonbow",300,750,700,700,2500,7);
    }

    @Override
    public Paladin copy() {
        return new Sehanine_Moonbow ();
    }

    public static void main(String[] args){

    }
}
