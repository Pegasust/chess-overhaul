package ultimac;

public abstract class UltimateChessPiece
{
    public final Player ogOwner;
    public Player currentOwner;
    public final Position ogPosition;
    public Position currentPos;

    protected float currentUltCharge;
    protected float ultChargeMultiplier;
    protected float maxUltCharge;
    protected float ultChargeRequired;

    public UltimateChessPiece(Player ogOwner, Position ogPosition)
    {
        this.ogOwner = ogOwner;
        currentOwner = ogOwner;
        this.ogPosition = ogPosition;
        currentPos = ogPosition;
    }

    public abstract String getFullName();
    public abstract String getDisplayName();
    public abstract boolean canMoveTo(Position pos);
    public boolean canUseUltimate()
    {
        return currentUltCharge >= ultChargeRequired;
    }
    public abstract void moveTo(Position pos);

}