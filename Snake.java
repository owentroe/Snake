
import java.util.Queue;
import java.util.LinkedList;

public class Snake
{
    private Directions direction = Directions.down;
    private Queue<Cell> segments = new LinkedList<Cell>();
    private CoordinatePair headCoord;

    /**
     *
     * @param start head location on start
     */
    public Snake(CoordinatePair start)
    {
        this.headCoord = start;
    }
    public Snake()
    {
        headCoord = new CoordinatePair(0,0);
    }

    /**
     * Shifts head in direction @link direction
     */
    public void updateHeadCoord()
    {
        CoordinatePair tmp = new CoordinatePair(headCoord.getX(), headCoord.getY());

        switch(direction)
        {
            case up:
                tmp.decrementY();
                break;

            case right:
                tmp.incrementX();
                break;

            case down:
                tmp.incrementY();
                break;

            case left:
                tmp.decrementX();
                break;
        }

        headCoord = tmp;
    }

    /**
     *
     * @return the CoordinatePair of head segment
     */
    public CoordinatePair getHeadCoord()
    {
        return headCoord;
    }

    /**
     * Adds segment to head end of snake.
     * If food is consumed, snake is grown (last segment not removed)
     * @param seg A square ahead of the head of snake in direction @see direction
     */
    public void addSegment(Cell seg)
    {
        segments.offer(seg);


        if(seg.getType() != CellType.food)
        {
            Cell tmp = segments.poll();
            tmp.setType(CellType.empty);
        }

        seg.setType(CellType.snake);
    }

    public int getLength()
    {
        return segments.size();
    }

    public void setDirection(Directions direction)
    {
        this.direction = direction;
    }
}
