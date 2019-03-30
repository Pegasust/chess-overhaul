// package chess_overhaul;

// import java.util.HashMap;
// import java.util.HashSet;

// public abstract class CustomizableOverhaulChessRule
// {
//     public HashSet<Integer> pawnMorphPositionPosId = new HashSet<Integer>();
//     public int MAX_X, MAX_Y;
//     public CustomizableDefaultPosition blackPositions, whitePositions;
//     public int totalPlayablePieces;
//     /**
//      * All methods that returns int type: if null means there is no such piece.
//      * Highly recommend the use of HashMap for performance and ease of read.
//      */
//     public abstract class CustomizableDefaultPosition
//     {
//         public abstract Integer getKingPosId();
//         /** 
//          * There can be many queens in customized game rules 
//          * */
//         public abstract Integer getQueenPosId(int i);
//         public abstract Integer getBishopPosId(int i);
//         public abstract Integer getKnightPosId(int i);
//         public abstract Integer getRookPosId(int i);
//         /**
//          * Chancellor is combination of rook and knight
//          */
//         public abstract Integer getChancellorPosId(int i);
//         /**
//          * Archbishop is combination of knight and bishop
//          */
//         public abstract Integer getArchbishopPosId(int i);
//         public abstract Integer getPawnPosId(int i);
//         public abstract boolean pieceExistsAt(int positionId);
//     }
//     /**
//      * King has piece id of 0
//      */
//     public abstract class HashMapCustomDefaultPos extends CustomizableDefaultPosition
//     {
//         protected final HashMap<Integer, Integer> positionIdMap = new HashMap<>();
//         protected final HashMap<Integer, Integer> pieceIdMap = new HashMap<>();
//         public final int
//             N_QUEEN, N_BISHOP, N_KNIGHT, N_ROOK, N_CHANCELLOR, N_ARCHBISHOP, N_PAWN;

//         public HashMapCustomDefaultPos(int nQueen, int nBishop, int nKnight,
//         int nRook, int nChancellor, int nArchbishop, int nPawn)
//         {
//             N_QUEEN = nQueen;
//             N_BISHOP = nBishop;
//             N_KNIGHT = nKnight;
//             N_ROOK = nRook;
//             N_CHANCELLOR = nChancellor;
//             N_ARCHBISHOP = nArchbishop;
//             N_PAWN = nPawn;
//             //Add hashmap here?
//             initializeHashMap();
//         }
//         protected abstract void initializeHashMap();

//         protected void addToHashMap(int xType, int id, Integer positionId)
//         {
//             Integer pieceId = xType + id;
//             this.positionIdMap.put(pieceId, positionId);
//             this.pieceIdMap.put(positionId, pieceId);
//         }
        
//         private int xBishop()
//         {
//             return N_QUEEN;
//         }
//         private int xKnight()
//         {
//             return N_QUEEN + N_BISHOP;
//         }
//         private int xRook()
//         {
//             return xKnight() + N_KNIGHT;
//         }
//         private int xChancellor()
//         {
//             return xRook() + N_ROOK;
//         }
//         private int xArchbishop()
//         {
//             return xChancellor() + N_CHANCELLOR;
//         }
//         private int xPawn()
//         {
//             return xArchbishop() + N_ARCHBISHOP;
//         }
//         @Override
//         public Integer getKingPosId() {
//             return positionIdMap.get(0);
//         }

//         @Override
//         public Integer getQueenPosId(int i) {
//             if(i > N_QUEEN) return null;
//             return positionIdMap.get(i);
//         }

//         @Override
//         public Integer getBishopPosId(int i) {
//             if(i > N_BISHOP) return null;
//             return positionIdMap.get(xBishop() + i);
//         }

//         @Override
//         public Integer getKnightPosId(int i) {
//             if(i > N_KNIGHT) return null;
//             return positionIdMap.get(xKnight() + i);
//         }

//         @Override
//         public Integer getRookPosId(int i) {
//             if(i > N_ROOK) return null;
//             return positionIdMap.get(xRook() + i);
//         }

//         @Override
//         public Integer getChancellorPosId(int i) {
//             if(i > N_CHANCELLOR) return null;
//             return positionIdMap.get(xChancellor() + i);
//         }

//         @Override
//         public Integer getArchbishopPosId(int i) {
//             if(i > N_ARCHBISHOP) return null;
//             return positionIdMap.get(xArchbishop() + i);
//         }

//         @Override
//         public Integer getPawnPosId(int i) {
//             if(i > N_PAWN) return null;
//             return positionIdMap.get(xPawn() + i);
//         }
        
//         @Override
//         public boolean pieceExistsAt(int positionId)
//         {
//             return pieceIdMap.containsKey(positionId);
//         }
//     }

//     public void assignPieces(ChessBoard b)
//     {
        
//     }
// }