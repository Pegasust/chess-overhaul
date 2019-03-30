package chess_overhaul;

import java.util.HashMap;
import java.util.HashSet;

public abstract class SRule
{
    public abstract class DefaultPosition
    {
        public abstract int getTotal();
        public abstract Integer getPositionId(int xType, int id);
        public abstract OverhaulChessPiece getPieceAt(ChessBoard b, Integer defaultPosId, boolean isWhite);
    }
    public abstract class HashMapDefaultPosition extends DefaultPosition
    {
        /**
         * Key: PositionId; 
         * Value: PieceId
         */
        private final HashMap<Integer, Integer> pieceIdMap = new HashMap<>();
        private final HashMap<Integer, Integer> positionIdMap = new HashMap<>();
        // public final int n[QUEEN, n[BISHOP, n[KNIGHT, n[ROOK, n[CHANCELLOR, n[ARCHBISHOP, n[PAWN;
        // public final int x[QUEEN, x[BISHOP, x[KNIGHT, x[ROOK, x[CHANCELLOR, x[ARCHBISHOP, x[PAWN;
        public final int[] n = new int[7],x = new int[7];
        public HashMapDefaultPosition(int nKing, int nQueen, int nBishop, int nKnight, int nRook, int nChancellor, int nArchbishop, int nPawn)
        {
            //Add hashmap here?
            n[KING] = nKing;
            n[QUEEN] = nQueen;
            n[BISHOP] = nBishop;
            n[KNIGHT] = nKnight;
            n[ROOK] = nRook;
            n[CHANCELLOR] = nChancellor;
            n[ARCHBISHOP] = nArchbishop;
            n[PAWN] = nPawn;
            assignXArray();
        }
        public HashMapDefaultPosition()
        {
            n[KING] = 1;
            n[QUEEN] = 1;
            n[BISHOP] = 2;
            n[KNIGHT] = 2;
            n[ROOK] = 2;
            n[PAWN] = 8;
            assignXArray();
        }
        private void assignXArray()
        {
            x[KING] = 0;
            x[QUEEN] = n[KING];
            x[BISHOP] = x[QUEEN] + n[QUEEN];
            x[KNIGHT] = x[BISHOP] + n[BISHOP];
            x[ROOK] = x[KNIGHT] + n[KNIGHT];
            x[CHANCELLOR] = x[ROOK] + n[ROOK];
            x[ARCHBISHOP] = x[CHANCELLOR] + n[CHANCELLOR];
            x[PAWN] = x[ARCHBISHOP] + n[ARCHBISHOP];
        }
        /**Use hashMapPut function. Return total number of pieces */
        public abstract void overridableHashMapInit();
        private void initializeHashMap()
        {
            //TODO: Do default positions here
        }
        public int getTotal()
        {
            return pieceIdMap.size();
        }
        public void hashMapPut(Integer position, Integer piece)
        {
            pieceIdMap.put(position,piece);
            positionIdMap.put(piece, position);
        }
        @Override
        public Integer getPositionId(int xType, int id) {
            if(id >= n[xType]) return null;
            return positionIdMap.get(x[xType] + id);
        }

        @Override
        public OverhaulChessPiece getPieceAt(ChessBoard b, Integer defaultPosId, boolean isWhite) {
            Integer pieceId = pieceIdMap.get(defaultPosId);
            if(pieceId == null) return null;
            int index;
            for(int i = PAWN; i >= KING; i--)
            {
                index = pieceId - x[i];
                if(index >= 0 && index < n[i])
                {
                    return OverhaulChessPiece.getNewPieceOfType(i, b, index, isWhite);
                }
            }
            return null;
        }
    }
    public final HashSet<Integer> pawnMorphPosition = new HashSet<>();
    public int MAX_X, MAX_Y;
    public final DefaultPosition dark, white;        
    public static final int
    KING = 0, QUEEN = 1, BISHOP = 2, KNIGHT = 3, ROOK = 4,
    CHANCELLOR = 5, ARCHBISHOP = 6, PAWN = 7;
    

    public SRule(DefaultPosition dark, DefaultPosition white)
    {
        this.dark = dark;
        this.white = white;
    }

    public Integer getDefaultPosition(boolean isWhite, int xType, int index)
    {
        if(isWhite) return white.getPositionId(xType, index);
        return dark.getPositionId(xType, index);
    }
    public int getTotalPlayablePieces()
    {
        return dark.getTotal() + white.getTotal();
    }
}