package chess_overhaul;

import java.util.ArrayList;
import java.util.HashSet;
/**
 * TODO: first sort the pieces & initialize
 */
public class ChessBoard
{
    /**length of x or y */
    public final int MAX_X, MAX_Y;
    public final OverhaulChessPiece[] pieces;
    public final SRule rule;
    public ChessBoard(SRule rule)
    {
        this.rule = rule;
        MAX_X = rule.MAX_X;
        MAX_Y = rule.MAX_Y;
        pieces = new OverhaulChessPiece[MAX_X * MAX_Y];
    }
    public void restartBoard_Mem()
    {
        int occupy;
        for(int i = 0; i < pieces.length; i++)
        {
            occupy = pieces[i].getRuleBondedDefaultPosition();
            //swap places
            if(i != occupy)
            {
                pieces[pieces[i].getRuleBondedDefaultPosition()] = pieces[i];
                i = occupy;
            }          
        }
    }
    public void restartBoard_Time() //mem: O(n); time: worst: O(n), best: O(logn)
    {
        HashSet<OverhaulChessPiece> sortedPieces = new HashSet<OverhaulChessPiece>();
        for(int i = 0; i < pieces.length && sortedPieces.size() < rule.getTotalPlayablePieces(); i++)
        {
            if(i != pieces[i].getRuleBondedDefaultPosition())
            {
                if(!sortedPieces.contains(pieces[i]))
                {
                    sortedPieces.add(pieces[i]);
                    //swap
                    OverhaulChessPiece occupy = pieces[pieces[i].getRuleBondedDefaultPosition()];
                    pieces[pieces[i].getRuleBondedDefaultPosition()] = pieces[i];
                    pieces[i] = occupy;
                }
            }
            else
            {
                sortedPieces.add(pieces[i]);
            }
        }
    }
    public void restartBoard_Bad() //mem: O(1) = 3, O(1) = 2; time: worst: O(n), best: O(n)
    {
        for(int i = 0; i < pieces.length; i ++)
        {
            int x = i;
            while(pieces[x] != null) //<-- swap places until the last piece you had is null
            {
                int occupied = pieces[x].getRuleBondedDefaultPosition();
                if(occupied != i)
                //swap
                {
                    pieces[pieces[x].getRuleBondedDefaultPosition()] = pieces[x];
                    x = occupied;                    
                }
            }
        }
    }
    public int getPositionId(int x, int y)
    {
        return MAX_X*y+x;
    }
    public int getXFromPosition(int positionId)
    {
        return positionId%MAX_X;
    }
    public int getYFromPosition(int positionId)
    {
        return positionId/MAX_X;
    }
    public ChessPiece getPiece(int x, int y)
    {
        return pieces[getPositionId(x,y)];
    }
    public boolean checkOutOfBounds(int x, int y)
    {
        return x >= MAX_X || y >= MAX_Y;
    }
    public Integer getValidNewPositionId(int currentPositionId, int moveX, int moveY)
    {        
        int newX = getXFromPosition(currentPositionId) + moveX;
        if(newX < MAX_X)
        {
            int newY = getYFromPosition(currentPositionId) + moveY;
            if(newY < MAX_Y)
            {
                return getPositionId(newX, newY);
            }
        }
        return null;        
    }
    public boolean isMoveValid(int currentPositionId, int moveX, int moveY)
    {
        int newX = getXFromPosition(currentPositionId) + moveX;
        if(newX < MAX_X)
        {
            int newY = getYFromPosition(currentPositionId) + moveY;
            if(newY < MAX_Y)
            {
                return true;
            }
        }
        return false;
    }
    public void addMoveIfValid(int currentPositionId, int moveX, int moveY, ArrayList<Integer> lst)
    {
        Integer x = getValidNewPositionId(currentPositionId, moveX, moveY);
        if(x != null)
        {
            lst.add(x);
        }
    }
    public void addToSetIfValid(int currentPositionId, int moveX, int moveY, HashSet<Integer> set)
    {
        Integer x = getValidNewPositionId(currentPositionId, moveX, moveY);
        if(x != null)
        {
            set.add(x);
        }
    }
}