package ultimate_chess;

public class Position
{
    public int x, y;
    //Pointer to ChessPiece obj
    protected ChessPiece piece;
    public Position(int x, int y, ChessPiece piece)
    {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public boolean equalsPos(Position other)
    {
        return x == other.x && y == other.y;
    }
    
}
