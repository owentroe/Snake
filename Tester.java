
public class Tester
{
   public static void main(String[] args)
   {
	  Cell board[][] = GameBoard.initializeBoard(new Cell[5][5]);

	  board[3][3] = new Cell(CellType.food);

	  GameBoard.addFood(board);
	  GameBoard.addFood(board);
	  ASCIIDrawer.drawBoard(board);

   }


}
