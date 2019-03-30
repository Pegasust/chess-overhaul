package ultimac;

public class UltimatePawn extends UltimateChessPiece
{
    private final String ogFullName;
    private final String ogDisplayName;

    private UltimateChessPiece morphedPiece;
    /**
     * id: from 0 to 8, from left most pawn to right most pawn
     */
    public UltimatePawn(Player ogOwner, Position ogPosition, boolean isWhite)
    {
        super(ogOwner, ogPosition);
        if(isWhite)
        {
            ogFullName = "white_pawn";
            ogDisplayName = "w_p";
        }
        else
        {
            ogFullName = "dark_pawn";
            ogDisplayName = "d_p";
        }
        unmorph();
    }
    protected void unmorph()
    {
        morphedPiece = null;
    }
    public String getFullName()
    {
        if(morphedPiece != null)
        {
            return morphedPiece.getFullName();
        }
        else
        {
            return ogFullName;
        }
    }
    public String getDisplayName()
    {
        if(morphedPiece != null)
        {
            return morphedPiece.getDisplayName();
        }
        else
        {
            return ogDisplayName;
        }
    }
    public void moveTo(Position pos)
    {
        if(morphedPiece == null)
        {
            pawnMoveTo(pos);
        }
        else
        {
            //Move as that morphedPiece
            morphedPiece.moveTo(pos);
        }
    }
    private void pawnMoveTo(Position pos)
    {
        //TODO: Move as a pawn
    }
    public boolean canMoveTo(Position pos)
    {
        if(morphedPiece == null)
        {
            return pawnCanMoveTo(pos);
        }
        return morphedPiece.canMoveTo(pos);
    }
    private boolean pawnCanMoveTo(Position pos)
    {
        //TODO: Check as a pawn
        return false;
    }
    
    public void morph(UltimateChessPiece piece)
    {
        morphedPiece = piece;
    }
}