import java.awt.Graphics;
import java.awt.Point;

public class Player implements Moveable
{
    private Point playerPos;
    private GameView view;
    private String filename;

    public Player(GameView view, String filename)
    {
        playerPos = new Point(400, 400);
        this.view = view;
        this.filename = filename;

    }

    public void update() 
    {
        
    }

    public void draw(Graphics g) 
    {
       view.drawOffSet(50, 30, playerPos.x, playerPos.y, g, filename);
    }
    
    public void movePlayer(String direction)
    {
        direction.toLowerCase();

        if(direction.equals("up"))
            playerPos.y -= 5;
        else if(direction.equals("down"))
            playerPos.y += 5;
        else if(direction.equals("left"))
            playerPos.x -= 5;
        else if(direction.equals("right"))
            playerPos.x += 5;
    }

}
