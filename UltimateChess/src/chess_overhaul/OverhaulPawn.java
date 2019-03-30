package chess_overhaul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class OverhaulPawn extends OverhaulBasiclPawn
{
    private final int myIndex;
    public OverhaulPawn(final ChessBoard board, final boolean isWhite, final int index)
    {
        super(board, isWhite);
        myIndex = index;
    }

    @Override
    protected boolean canUseUlt()
    {
        if(morphedPiece != null)
        {
            return morphedPiece.canUseUlt();
        }
        return super.canUseUlt();
    }
    @Override
    protected void useUlt()
    {
        if(morphedPiece != null)
        {
            morphedPiece.useUlt();
        }
        else
        {
            super.useUlt();
        } 
    }
    @Override
    public int[] getMovableArray()
    {
        if(morphedPiece != null)
        {
            return morphedPiece.getMovableArray();
        }
        return super.getMovableArray();
    }
    @Override
    public ArrayList<Integer> getMovablePositionId()
    {
        if(morphedPiece != null)
        {
            return morphedPiece.getMovablePositionId();
        }
        return super.getMovablePositionId();
    }
    @Override
    public HashSet<Integer> getMovableHashSet()
    {
        if(morphedPiece != null)
        {
            return morphedPiece.getMovableHashSet();
        }
        return super.getMovableHashSet();
    }
    @Override
    public HashSet<Integer> getMoveOnlyPositions()
    {
        if(morphedPiece != null)
        {
            return morphedPiece.getMoveOnlyPositions();
        }
        return super.getMoveOnlyPositions();
    }
    @Override
    public HashMap<Integer, OverhaulChessPiece> getAttackOnlyPositions() 
    {
        if(morphedPiece != null)
        {
            return morphedPiece.getAttackOnlyPositions();
        }
        return super.getAttackOnlyPositions();
    }

    @Override
    public int getRuleBondedDefaultPosition() {
        return board.rule.getDefaultPosition(isWhite, SRule.PAWN, myIndex);
    }

}