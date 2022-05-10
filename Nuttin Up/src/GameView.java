import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

public class GameView extends JPanel implements KeyListener, MouseListener
{
    private GameState state;
    private Dimension size;
    private JFrame frame;
    private JPanel panel;

    public GameView(GameState state)
    {
        this.state = state;

        size = new Dimension(800, 800);
        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = this;
        frame.setContentPane(panel);

        this.setMaximumSize(size);
        this.setPreferredSize(size);
        this.setMinimumSize(size);

        frame.pack();
        frame.setVisible(true);

        addKeyListener(this);
        setFocusable(true);

        addMouseListener(this);
    }

    public void paint(Graphics g)
    {
        state.drawAll(g);
    }

    public void drawOffSet(int width, int height, int x, int y, Graphics g, String filename)
        {
            g.drawImage(ResourceLoader.getLoader().getImage(filename), x - (width/2), y - (height/2), width, height, null);
        }
    
    public void keyTyped(KeyEvent e) 
    {
        
    }

    public void keyPressed(KeyEvent e) 
    {
        int keycode = e.getKeyCode();

        if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP)
            state.movePlayer("up");
        else if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) 
            state.movePlayer("down");
        else if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT)
            state.movePlayer("left");
        else if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT)
            state.movePlayer("right");
        else if(keycode == KeyEvent.VK_SPACE)
            state.playerShoot();
    }

    public void keyReleased(KeyEvent e) 
    { 
        
    }

    public void mouseClicked(MouseEvent e) 
    {

        
    }

    public void mousePressed(MouseEvent e) 
    {
        System.out.println("X: " + e.getX() + " Y: " + e.getY());
    }

    public void mouseReleased(MouseEvent e) 
    {

        
    }

    public void mouseEntered(MouseEvent e) 
    {

        
    }

    public void mouseExited(MouseEvent e) 
    {

        
    }

}
