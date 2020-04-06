package Main;

public class Piece
{
    public String name;
    private String val;    //Value of piece that gets written on board

    public Piece(String n, String v)
    {
        /*Constructor for piece*/
        val = v;
        name = n;
    }

    public String getVal(){
        /*Method for obtaining value of piece*/
        return val;
    }

    public static void main(String[] args) {
        // write your code here
    }

}
