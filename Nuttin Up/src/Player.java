import java.awt.Graphics;
import java.awt.Point;

public class Player implements Moveable
{
    private Point playerPos;
    private GameView view;
    private String filename;
    private String direction;
    private GameState state;

    public Player(GameView view, String filename, GameState state)
    {
        playerPos = new Point(400, 400);
        this.view = view;
        this.filename = filename;
        this.state = state;
    }

    public void update() 
    {
        
    }

    public void draw(Graphics g) 
    {
       view.drawOffSet(50, 60, playerPos.x, playerPos.y, g, filename);
    }
    
    public void movePlayer(String direction)
    {
        direction.toLowerCase();
        this.direction = direction;

        if(direction.equals("up"))
        {
            playerPos.y -= 5;
            filename = "squirrel-facing-front.png";
        }
        else if(direction.equals("down"))
        {
            playerPos.y += 5;
            filename = "squirrel-facing-back.png";
        }
        else if(direction.equals("left"))
        {
            playerPos.x -= 5;
            filename = "squirrel-facing-left.png";
        }
        else if(direction.equals("right"))
        {
            playerPos.x += 5;
            filename = "squirrel-facing-right.png";
        }
    }

    public void playerShoot()
    {
        state.addObject(new PlayerAcorn(view, direction, playerPos.x, playerPos.y));
    }

}
