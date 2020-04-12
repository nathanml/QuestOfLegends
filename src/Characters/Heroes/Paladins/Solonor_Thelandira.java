package Characters.Heroes.Paladins;

public class Solonor_Thelandira extends Paladin {

    public Solonor_Thelandira()
    {
        super("Solonor Thelandira",300,750,650,700,2500,7);
    }

    @Override
    public Paladin copy() {
        return new Solonor_Thelandira ();
    }

    public static void main(String[] args){

    }
}
