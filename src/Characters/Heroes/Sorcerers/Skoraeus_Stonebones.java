package Characters.Heroes.Sorcerers;

public class Skoraeus_Stonebones extends Sorcerer {

    public Skoraeus_Stonebones()
    {
        super("Skoraeus Stonebones",800,850,600,450,2500,6);
    }

    @Override
    public Sorcerer copy() {
        return new Skoraeus_Stonebones ();
    }

    public static void main(String[] args){

    }
}
