package ultimac;

public class Position
{
    public UltimateChessPiece piece;
    public int chessBoardID;
    public Position(UltimateChessPiece piece, int chessBoardID)
    {
        this.piece = piece;
        this.chessBoardID = chessBoardID;
    }
}