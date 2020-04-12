package Characters.Heroes.Paladins;

public class Garl_Glittergold extends Paladin {

    public Garl_Glittergold()
    {
        super("Garl Glittergold",100,600,500,400,2500,5);
    }

    @Override
    public Paladin copy() {
        return new Garl_Glittergold ();
    }

    public static void main(String[] args){

    }
}
