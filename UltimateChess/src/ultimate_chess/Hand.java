package ultimate_chess;

public enum Hand
{
    kLeft, kRight;
    public static Hand getHand(int input)
    {
        switch(input)
        {
            case 0:
                return kRight;
            case 1:
                return kLeft;
            default:
                return getHand(input&1);
        }
    }
}
