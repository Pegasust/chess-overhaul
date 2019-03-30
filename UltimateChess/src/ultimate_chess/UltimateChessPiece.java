package ultimate_chess;

//All chess pieces must not move out of border unless stated otherwise
public abstract class ChessPiece
{
    public final String fullName;
    protected final String displayName;
    protected final Position[] movables;
    protected final Position defaultPos;
    protected final Player op; //original player/owner
    protected Position pos;
    protected Player player;
    protected boolean isEliminated;
    //TODO: add the piece reference to the player upon inheriting
    public ChessPiece(String fullName, String displayName, Position[] movables, Position defaultPos, Player p)
    {
        this.fullName = fullName;
        this.displayName = displayName;
        this.movables = movables;
        this.defaultPos = defaultPos;
        this.pos = defaultPos;
        player = p;
        op = p;
        isEliminated = false;
    }
    protected void resetPiece()
    {
        player = op;
        isEliminated = false;
        forceSwapMoveTo(defaultPos);
    }
    
    public abstract void attack(ChessPiece opponent);
    public boolean canAttack(ChessPiece opponent)
    {
        return canMoveTo(opponent.pos) && opponent.player != this.player;
    }
    protected void onAttack(ChessPiece opponent)
    {
        opponent.onAttacked(this);
    }
    protected abstract void onAttacked(ChessPiece opponent);
    
    public abstract void moveTo(Position p);
    public boolean canMoveTo(Position p)
    {
        Position displacement;
        displacement.x = p.x - pos.x;
        displacement.y = p.y - pos.y;
        for(int i = 0; i < movables.length; i++)
        {
            if(movables[i].equalsPos(displacement))
            {
                return true;
            }
        }
        return false;
    }
    protected void onMove(Position p)
    {
        pos.piece = null;
        pos = p;
        pos.piece = this;
    }
    protected final void forceSwapMoveTo(Position p)
    {
        if(p.piece != null) //If occupied by other piece
        {
            //swap positions
            p.piece.pos = pos;
            pos.piece = p.piece;
            p.piece = this;
            pos = p;
        }
        else
        {
            this.pos.piece = null;
            this.pos = p;
            this.pos.piece = this;
        }
    }
}
