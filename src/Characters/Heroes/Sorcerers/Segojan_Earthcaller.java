package Characters.Heroes.Sorcerers;

public class Segojan_Earthcaller extends Sorcerer{

    public Segojan_Earthcaller()
    {
        super("Segojan_Earthcaller",900,800,500,650,2500,6);
    }

    @Override
    public Sorcerer copy() {
        return new Segojan_Earthcaller ();
    }

    public static void main(String[] args)
    {

    }
}
