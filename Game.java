import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements ActionListener, KeyListener
{
    private final int WIDTH = 10;
    private final int HEIGHT = 10;

    private Snake snake;

    private GameBoard board;

    public Game()
    {
        board = new GameBoard(WIDTH, HEIGHT, this);
        snake = new Snake();

        Timer gameThread = new Timer(1000, this);
        gameThread.setRepeats(true);
        gameThread.start();

    }

    /**
     * Checks collision with self, border, or food (causes snake growth -- handled in snake class)
     * Checks if food exists on board, if not, adds food
     * updates score to GameWindow
     */
    private void move()
    {
        //shifts headCoord w/o adding segment, useful for snake crossing itself detection
        snake.updateHeadCoord();

        Cell nextHeadCell = board.getCell(snake.getHeadCoord());

        if(nextHeadCell == null)
        {
            /* Invalid coord ===> off board */
            endGame();
        }

        //snake hits self
        if(nextHeadCell.getType() == CellType.snake)
        {
            endGame();
        }


        //changes Cell nextHeadCell to type snake
        snake.addSegment(nextHeadCell);

        if(!board.hasFood())
        {
            board.addFood();
        }

        board.setScore(snake.getLength() - 1);
        board.drawBoard();
    }

    //temporary
    public void endGame()
    {
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        move();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent)
    {}

    @Override
    public void keyPressed(KeyEvent keyEvent)
    {
        switch(keyEvent.getKeyCode())
        {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                snake.setDirection(Directions.up);
                break;

            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                snake.setDirection(Directions.down);
                break;

            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                snake.setDirection(Directions.left);
                break;

            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent)
    {}
}
