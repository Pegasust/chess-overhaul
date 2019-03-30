package ultimac;

public class ChessBoard
{
    private final Position[] allPositions;
    public final int MAX_X, MAX_Y; //Default = 8

    public ChessBoard()
    {
        MAX_X = 8; MAX_Y = 8;
        allPositions = new Position[MAX_X * MAX_Y];
        for(int i = 0; i < MAX_X * MAX_Y; i++)
        {
            //TODO: if possible, change null to an actual object
            allPositions[i] = new Position(null, i);
        }
    }
    public Position getPositionObj(int x, int y)
    {
        return allPositions[getPositionIndex(x, y)];
    }
    public int getPositionIndex(int x, int y)
    {
        return MAX_X * y + x;
    }
}