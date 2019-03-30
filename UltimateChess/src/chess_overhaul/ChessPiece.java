package chess_overhaul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class ChessPiece
{
    protected final ChessBoard board;
    protected Integer currentPositionId;
    public ChessPiece(ChessBoard board)
    {
        this.board = board;
    }
    public abstract boolean isWhite();
    public abstract String getFullName();
    public abstract String getAbbrevName();
    public abstract int[] getMovableArray();
    public abstract HashSet<Integer> getMovableHashSet();
    public abstract ArrayList<Integer> getMovablePositionId();
    public abstract HashSet<Integer> getMoveOnlyPositions();
    public abstract HashMap<Integer, OverhaulChessPiece> getAttackOnlyPositions();
    public abstract void moveToPositionId(int positionId);
    public abstract void attack(int positionId);

}