import java.awt.Graphics;
import java.awt.Point;

public class PlayerAcorn implements Moveable
{

    private int speed;
    private Point pos;
    private GameView view;
    private String filename;
    private String direction;

    public PlayerAcorn(GameView view, String direction, int x, int y)
    {
        this.view = view;
        if(direction == null)
            this.direction = "down";
        else
            this.direction = direction.toLowerCase();
        filename = "acorn.png";
        speed = 5;
        this.pos = new Point(x, y);
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
    }

    public void draw(Graphics g) 
    {
        view.drawOffSet(50, 50, pos.x, pos.y, g, filename);
    }
    
}
