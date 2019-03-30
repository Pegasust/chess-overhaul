package ultimate_chess;

public class Player
{
    private ChessPiece[] myPieces;
    public Player(boolean isWhite, ChessBoard board)
    {
        myPieces = UltimateChessPieceHelper.getAllPieces(isWhite, this, board);
    }
    protected void sortMyPieces()
    {
        for(int i = 0; i < myPieces.length; i++)
        {
            myPieces[i].resetPiece();
        }
    }
}
