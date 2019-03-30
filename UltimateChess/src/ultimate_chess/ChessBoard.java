package ultimate_chess;

public class ChessBoard
{
    protected final Position[][] pos;
    public static final int DEFAULT_MAX_X = 8, DEFAULT_MAX_Y = 8;
    
    public ChessBoard(final int maxX, final int maxY)
    {
        pos = new Position[maxX][maxY];
        for(int i = 0; i < maxX ; i++)
        {
            for(int j = 0; j < maxY; j++)
            {
                pos = new Position(i, j);
            }
        }
    }
    public ChessBoard()
    {
        pos = new Position[DEFAULT_MAX_X][DEFAULT_MAX_Y];
        for(int i = 0; i < DEFAULT_MAX_X ; i++)
        {
            for(int j = 0; j < DEFAULT_MAX_Y; j++)
            {
                pos = new Position(i, j);
            }
        }
    }
    public Position getPositionPtr(int x, int y)
    {
        return pos[x][y];
    }
    public Position getPostionPtr(Position p)
    {
        return pos[p.x][p.y];
    }
}
