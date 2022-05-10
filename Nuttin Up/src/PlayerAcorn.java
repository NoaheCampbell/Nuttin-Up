import java.awt.Graphics;
import java.awt.Point;

public class PlayerAcorn implements Moveable
{

    private int speed;
    private Point pos;
    private GameView view;
    private String filename;
    private String direction;
    private GameState state;
    private int width;
    private int height;

    public PlayerAcorn(GameView view, String direction, int x, int y, GameState state)
    {
        this.view = view;
        if(direction == null)
            this.direction = "down";
        else
            this.direction = direction.toLowerCase();
        filename = "acorn.png";
        speed = 5;
        this.pos = new Point(x, y);
        this.state = state;
        width = 50;
        height = 50;
    }

    public void update() 
    {
        if(direction.equals("up"))
            pos.y -= speed;
        else if(direction.equals("down"))
            pos.y += speed;
        else if(direction.equals("left"))
            pos.x -= speed;
        else if(direction.equals("right"))
            pos.x += speed;

        if(pos.x > 800 || pos.x < 0 || pos.y > 800 || pos.y < 0)
        {
            state.removeAcorn(this);
            state.removeObject(this);
        }
    }

    public void draw(Graphics g) 
    {
        view.drawOffSet(width, height, pos.x, pos.y, g, filename);
    }

    public Point getAcornPosition()
    {
        return pos;
    }

    public int getAcornWidth()
    {
        return width;
    }

    public int getAcornHeight()
    {
        return height;
    }

    public int getAcornSpeed()
    {
        return speed;
    }

    public void setAcornSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
    
}
