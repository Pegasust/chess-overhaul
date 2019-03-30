package ultimate_chess;

public class ChessGame
{
    ChessBoard board;
    Player black, white;
    Player pCurrentTurn;
    int nCurrentTurn;
    
    
    public ChessGame()
    {
        board = new ChessBoard();
        
    }
    
    public void resetBoard()
    {
        black.sortMyPieces();
        white.sortMyPieces();
        pCurrentTurn = white;
        nCurrentTurn = 0;
    }
}
