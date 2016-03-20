import javax.swing.*;
import java.awt.event.KeyListener;

public class GameBoard extends JFrame
{
    private Cell[][] board;
    private KeyListener keyListener;
    private int score = 0;

    /**
     * Generates GameWindow
     * @param width width in number of cells (NOT pixels)
     * @param height height in numer of cells (NOT pixels)
     * @param keyListener eh.
     */
    public GameBoard(int width, int height, KeyListener keyListener)
    {
        board = new Cell[width][height];

        GameBoard.initializeBoard(board);

        this.keyListener = keyListener;
    }

    public void drawBoard()
    {

    }

   /**
    * Gets cell at location @link coord
    * @param coord a CoordinatePair - should be on board, else null is returned.
    * @return Will return cell at given coord if coord is on board, else returns null
    */
   public Cell getCell(CoordinatePair coord)
    {
        if(!isOnBoard(coord))
            return null;

        return board[coord.getX()][coord.getY()];
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    /**
     * Checks whether a food cell exists on the board
     * @return true: food exists. false: food doesn't exist
     */
    public boolean hasFood()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; i < board[i].length; j++)
            {
                if(board[i][j].getType() == CellType.food)
                    return true;
            }
        }
        return false;
    }

   /**
    *
    * @param coord a CoordinatePair
    * @return true if coord falls within bounds of board
    */
   public boolean isOnBoard(CoordinatePair coord)
    {
        boolean b = true;
       
         //all conditions must be true
        b &= !(coord.getX() < 0);
        b &= !(coord.getX() > this.getWidth());
        b &= !(coord.getY() < 0);
        b &= !(coord.getY() > this.getHeight());

        return b;
    }

    //Not a great way to do this -- perhaps fix sometime
   public void addFood()
   {
      GameBoard.addFood(board);
   }
   public static void addFood(Cell[][] board)
   {
      int x = (int) (Math.random() * board.length);
      int y = (int) (Math.random() * board[0].length);

      if(board[x][y].getType() != CellType.empty)
      {
         GameBoard.addFood(board);
      }
   }

   public int getWidth()
   {
      return board.length;
   }
   public int getHeight()
   {
      return board[0].length;
   }

   public static Cell[][] initializeBoard(Cell[][] board)
   {
      for(int i = 0; i < board.length; i++)
      {
         for(int j = 0; j < board[i].length; j++)
         {
            board[i][j] = new Cell();
         }
      }
      //attempt to fix issue
      return board;
   }
}
