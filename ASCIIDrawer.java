public class ASCIIDrawer
{
   public static void drawBoard(Cell[][] board)
   {
	  //clearScreen();

	  char tmp =  ' ';

	  for(int i = 0; i < board.length; i++)
	  {
		 for(int j = 0; j < board.length; j++)
		 {
			switch(board[i][j].getType())
			{
			   case food:
				  tmp = '@';
				  break;
			   case snake:
				  tmp = '#';
				  break;
			   case empty:
				  tmp = ' ';
			}

			System.out.print(tmp);
		 }
		 System.out.println();
	  }
   }
   public static boolean clearScreen()
   {
	  if(System.getProperty("os.name").contains("win"))
	  {
		 try
		 {
			//supposedly works in Windows
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		 }
		 catch(Exception e)
		 {
			e.printStackTrace();
			return false;
		 }
	  }
	  else //Linux
	  {
		 final String ESC = "\033[";
		 System.out.println(ESC + "2J");
	  }

	  return true;
   }

}
