import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Point;

public class GameControl implements Runnable, ActionListener 
{
    private GameState state;
    private GameView view;
    private Player player;
    private Scanner fileScanner;
    private File fileStats;

    public void run() 
    {
        MapLoader mapLoader = new MapLoader();
        state = new GameState(mapLoader);
        view = new GameView(state);
        player = new Player(view, "squirrel-facing-down.png", state);

        state.setPlayer(player);
        state.setGameView(view);

        state.addObject(mapLoader);
        state.addObject(player);

        fileStats = new File("src/EnemyCatPositionsLevelOne.txt");
    
        try 
        {
            fileScanner = new Scanner(fileStats);
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }

        int catPositionX = 0;
        int catPositionY = 0;

        while(fileScanner.hasNext())
        {
            String word = fileScanner.next();
            String direction = null;

            if(word.equals("X:"))
                catPositionX = fileScanner.nextInt();
            else if(word.equals("Y:"))
                catPositionY = fileScanner.nextInt();
            else if(word.equals("direction:"))
                direction = fileScanner.next();
            
            if(direction != null)
            {
                Point enemyCatPos = new Point(catPositionX, catPositionY);
                state.addObject(new EnemyCat(enemyCatPos, view, state, direction, player));
            }
        }

        Timer timer = new Timer(17, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) 
    {
        state.updateAll();

        view.repaint();
    }
}
