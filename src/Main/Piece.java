package Main;

public class Piece
{
    public String name;
    private String val;    //Value of piece that gets written on board
    public boolean isHeroPiece;

    public Piece(String n, String v, boolean heroPiece)
    {
        /*Constructor for piece*/
        val = v;
        name = n;
        isHeroPiece = heroPiece;
    }

    public String getVal(){
        /*Method for obtaining value of piece*/
        return val;
    }

    public static void main(String[] args) {
        // write your code here
    }

}
