import javax.swing.*;

public class Cell extends JPanel
{
    private CellType type;

    public Cell()
    {
        this(CellType.empty);
    }
    public Cell(CellType type)
    {
        this.type = type;
    }


    public void setType(CellType type)
    {
        this.type = type;
    }

    public CellType getType()
    {
        return type;
    }
}
