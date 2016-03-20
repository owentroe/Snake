public class CoordinatePair
{
    private int x, y;

    public CoordinatePair(int x, int y)
    {
        setX(x);
        setY(y);
    }

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }

    public void incrementX()
    {
        x++;
    }
    public void decrementX()
    {
        x--;
    }

    public void incrementY()
    {
        y++;
    }
    public void decrementY()
    {
        y--;
    }
}
