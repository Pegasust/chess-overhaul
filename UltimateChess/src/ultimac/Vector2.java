package ultimac;

public class Vector2
{
    //index 0: x; index 1: y;
    private final int[] value;
    public Vector2()
    {
        value = new int[2];
    }
    public Vector2(int x, int y)
    {
        value = new int[2];
        value[0] = x;
        value[1] = y;
    }
    public int getX()
    {
        return value[0];
    }
    public int getY()
    {
        return value[1];
    }
    public void setX(int newVal)
    {
        value[0] = newVal;
    }
    public void setY(int newVal)
    {
        value[1] = newVal;
    }
}