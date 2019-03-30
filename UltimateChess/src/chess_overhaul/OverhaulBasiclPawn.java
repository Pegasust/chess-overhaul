package chess_overhaul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 * TODO: morph function needs to be implemented
 * TODO: ult function needs to be implemented
 * TODO: en passant needs to be implemented
 * TODO: move needs to be implemented
 * TODO: replace some names with unicode symbols
 */
public abstract class OverhaulBasiclPawn extends OverhaulChessPiece
{
    protected boolean isWhite;
    private boolean movedOnce = false;
    protected OverhaulChessPiece morphedPiece;
    public OverhaulBasiclPawn(ChessBoard board, boolean isWhite)
    {
        super(board);
        this.isWhite = isWhite;
        ultChargeMultiplier = 1.0f;
        morphedPiece = null;
    }
    @Override
    protected boolean canUseUlt() {
        return false;
    }

    @Override
    protected void useUlt() {

    }

    @Override
    public String getFullName() {
        if(morphedPiece != null)
        {
            return morphedPiece.getFullName();
        }
        return isWhite?"white_pawn":"dark_pawn";
    }

    @Override
    public String getAbbrevName() {
        if(morphedPiece != null)
        {
            return morphedPiece.getAbbrevName();
        }
        return isWhite?"w_p": "d_p";
    }

    @Override
    public int[] getMovableArray()
    {
        ArrayList<Integer> lst = getMovablePositionId();
        int[] arr = new int[lst.size()];
        for(int i = 0; i < arr.length; i ++)
        {
            arr[i] = lst.get(i);
        }
        return arr;
    }
    @Override
    public ArrayList<Integer> getMovablePositionId() {
        ArrayList<Integer> resultLst = new ArrayList<>(4);
        int upDir = isWhite?1:-1;
        if(!movedOnce)
        {
            board.addMoveIfValid(currentPositionId, 0, 2*upDir, resultLst);
        }
        Integer newMove = board.getValidNewPositionId(currentPositionId, 1, 1*upDir);
		//Check right
        addIfCanAttack(resultLst, newMove);
        //Check left
        newMove = board.getValidNewPositionId(currentPositionId, -1, 1*upDir);
        addIfCanAttack(resultLst, newMove);
        return resultLst;
    }

    @Override
    public HashSet<Integer> getMovableHashSet() {
        HashSet<Integer> result = new HashSet<Integer>();
        int upDir = isWhite?1:-1;
        if(!movedOnce)
        {
            board.addToSetIfValid(currentPositionId, 0, 2, result);
        }
        Integer newMove = board.getValidNewPositionId(currentPositionId, 1, 1*upDir);
		//Check right
        addIfCanAttack(result, newMove);
        //Check left
        newMove = board.getValidNewPositionId(currentPositionId, -1, 1*upDir);
        addIfCanAttack(result, newMove);
        return result;
    }
    private void addIfCanAttack(ArrayList<Integer> lst, Integer newMove)
    {
        if(newMove != null && board.pieces[newMove] != null && board.pieces[newMove].isWhite() != isWhite)
        {
            lst.add(newMove);
        }
    }
    private void putIfCanAttack(HashMap<Integer, OverhaulChessPiece> map, Integer newMove)
    {
        if(newMove != null)
        {
            OverhaulChessPiece piece = board.pieces[newMove];
            if(piece != null && piece.isWhite() != isWhite)
            {
                map.put(newMove, piece);
            }
        }
    }
    private void addIfCanAttack(HashSet<Integer> set, Integer newMove)
    {
        if(newMove != null && board.pieces[newMove] != null && board.pieces[newMove].isWhite() != isWhite)
        {
            set.add(newMove);
        }
    }
    
    @Override
    public boolean isWhite() {
        return isWhite;
    }

    @Override
    public HashSet<Integer> getMoveOnlyPositions() {
        HashSet<Integer> result = new HashSet<>();
        int dir = isWhite()?1:-1;
        if(!movedOnce)
        {
            board.addToSetIfValid(currentPositionId, 0, 2 * dir, result);
        }
        board.addToSetIfValid(currentPositionId, 0, dir, result);
        return result;
    }

    @Override
    public HashMap<Integer, OverhaulChessPiece> getAttackOnlyPositions() {
        HashMap<Integer, OverhaulChessPiece> result = new HashMap<>();
        int dir = isWhite?1:-1;
        putIfCanAttack(result, board.getValidNewPositionId(currentPositionId, -1, dir));
        putIfCanAttack(result, board.getValidNewPositionId(currentPositionId, 1, dir));
        return result;
    }


}