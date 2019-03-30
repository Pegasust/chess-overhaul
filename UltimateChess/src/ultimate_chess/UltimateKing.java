package ultimate_chess;

public class UltimateKing extends UltimateChessPiece
{
    public static final Position[] MOVABLES = 
    {        
        new Position(-1, 1),    new Position(0, 1),     new Position(1, 1),
        new Position(-1, 0),                            new Position(1, 0),
        new Position(-1, -1),   new Position(0, -1),    new Position(1, -1)
    };
        
    public UltimateKing(boolean isWhite)
    {
        String fullName, displayName;
        if(isWhite)
        {
            fullName = "white_king";
            displayName = "w_k";
            
        }
        else
        {
            fullName = "dark_king";
            displayName = "d_k";
        }
        
        
    }
    
}
