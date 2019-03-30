package chess_overhaul;

import java.util.HashMap;
import java.util.HashSet;

public abstract class OverhaulChessPiece extends ChessPiece
{
    protected float ultChargeMultiplier;
    protected float currentUltCharge;
    protected static final float DEFAULT_ULT_CHARGE_THRESHOLD = 10.0f;
    protected static final float DEFAULT_ULT_CHARGE_LIMIT = 10.0f;
    public OverhaulChessPiece(ChessBoard board)
    {
        super(board);
    }
    public static final OverhaulChessPiece getNewPieceOfType(int type, ChessBoard board, int index, boolean white)
    {
        switch(type)
        {
            case SRule.KING:
                return new OverhaulKing(board, white);
            case SRule.QUEEN:
                return new OverhaulQueen(board, white, index);
            case SRule.BISHOP:
                return new OverhaulBishop(board, white, index);
            case SRule.KNIGHT:
                return new OverhaulKnight(board, white, index);
            case SRule.ROOK:
                return new OverhaulRook(board, white, index);
            case SRule.CHANCELLOR:
                return new OverhaulChancellor(board, white, index);
            case SRule.ARCHBISHOP:
                return new OverhaulArchbishop(board, white, index);
            case SRule.PAWN:
                return new OverhaulPawn(board, white, index);
            default:
                return null;
        }
    }
    public abstract int getRuleBondedDefaultPosition();
    public boolean tryUseUlt()
    {
        if(canUseUlt())
        {
            useUlt();
            return true;
        }
        return false;
    }
    protected boolean canUseUlt()
    {
        return currentUltCharge >= DEFAULT_ULT_CHARGE_THRESHOLD;
    }
    protected abstract void useUlt();
    public void attack(int positionId)    
    {
        HashMap<Integer, OverhaulChessPiece> map = getAttackOnlyPositions();
        OverhaulChessPiece piece = map.get(positionId);
        if(piece != null)
        {
            board.pieces[positionId] = this;
            board.pieces[currentPositionId] = null;
        }
    }
    public void moveToPositionId(int positionId)
    {
        HashSet<Integer> movs = getMovableHashSet();
        if(movs.contains(positionId))
        {
            board.pieces[positionId] = this;
            board.pieces[currentPositionId] = null;
        }
    }
    // /**
    //  * Very dangerous, can cause the whole chess board to reset.
    //  * Only use to reset chess board.
    //  */
    // public void restartPosition()
    // {
    //     OverhaulChessPiece occupyingPiece = board.pieces[getRuleBondedDefaultPosition()];
        
    // }
}