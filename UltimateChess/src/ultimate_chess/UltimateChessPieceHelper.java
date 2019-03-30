package ultimate_chess;

//A1 is left hand rook (white)
//A8 is right hand rook (black)
public class UltimateChessPieceHelper
{
    public static final int KING = 0;
    public static final int QUEEN = 1;
    public static final int LEFT_ROOK = 2;
    public static final int RIGHT_ROOK = 3;
    public static final int LEFT_KNIGHT = 4;
    public static final int RIGHT_KNIGHT = 5;
    public static final int LEFT_BISHOP = 6;
    public static final int RIGHT_BISHOP = 7;
    public static final int LEFT_MOST_PAWN = 8;
    public static final int RIGHT_MOST_PAWN = 15;
    public static final int N_MAX_PIECES = 16;
    public static int getPawnInt(int positionFromLeft)
    {
        return Math.min(RIGHT_MOST_PAWN, Math.max(LEFT_MOST_PAWN + positionFromLeft, LEFT_MOST_PAWN));
    }
    public static UltimateChessPiece[] getAllPieces(boolean isWhitePieces, player o, ChessBoard board)
    {
        UltimateChessPiece[] arr = new UltimateChessPiece[N_MAX_PIECES];
        //Implementation
        for(int i = 0; i < N_MAX_PIECES; i++)
        {
            arr[i] = newPieceFromInt(i, isWhitePieces, o, board);
        }
        return arr;
    }
    private static UltimateChessPiece newPieceFromInt(int input, boolean b, Player o, ChessBoard board)
    {
        switch(input)
        {
            case KING:
                return new UltimateKing(b, o, board);
            case QUEEN:
                return new UltimateQueen(b, o, board);
            case LEFT_ROOK:
            case RIGHT_ROOK:
                return new UltimateRook(Hand.getHand(input), b, o, board);
            case LEFT_KNIGHT:
            case RIGHT_KNIGHT:
                return new UltimateKnight(Hand.getHand(input), b, o, board);
            case LEFT_BISHOP:
            case RIGHT_BISHOP:
                return new UltimateBishop(Hand.getHand(input), b, o, board);
            default:
                if(LEFT_MOST_PAWN<=input&&input<=RIGHT_MOST_PAWN)
                {
                    return new UltimatePawn(input-LEFT_MOST_PAWN, b, o, board);
                }
                return null;
        }
    }
}
