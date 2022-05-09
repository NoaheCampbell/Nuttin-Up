import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameControl implements Runnable, ActionListener 
{
    private GameState state;
    private GameView view;
    private Player player;

    public void run() 
    {
        state = new GameState();
        view = new GameView(state);
        player = new Player(view, "squirrel-facing-back.png", state);

        state.setPlayer(player);

        state.addObject(player);

        Timer timer = new Timer(17, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) 
    {
        state.updateAll();

        view.repaint();
    }
}
