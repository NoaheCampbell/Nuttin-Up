import java.awt.Graphics;
import java.awt.Point;

public class Player implements Moveable
{
    private Point playerPos;
    private GameView view;
    private String filename;
    private String direction;
    private GameState state;
    private int width;
    private int height;
    private int speed;
    private boolean allowMovementUp;
    private boolean allowMovementDown;
    private boolean allowMovementLeft;
    private boolean allowMovementRight;

    public Player(GameView view, String filename, GameState state)
    {
        playerPos = new Point(40, 650);
        this.view = view;
        this.filename = filename;
        this.state = state;

        width = 50;
        height = 60;
        speed = 10;

        allowMovementUp = true;
        allowMovementDown = true;
        allowMovementLeft = true;
        allowMovementRight = true;
    }

    public void update() 
    {
        if(playerPos.x - (width/2) <= 0)
            allowMovementLeft = false;
        else if(playerPos.x + (width/2) >= 800)
            allowMovementRight = false;
        else if(playerPos.y - (height/2) <= 0)
            allowMovementUp = false;
        else if(playerPos.y + (height/2) >= 800)
            allowMovementDown = false;
        else
            resetPlayerMovementStatus();       
    }

    public void draw(Graphics g) 
    {
       view.drawOffSet(width, height, playerPos.x, playerPos.y, g, filename);
    }
    
    public void movePlayer(String direction)
    {
        direction.toLowerCase();
        this.direction = direction;

        if(direction.equals("up") && allowMovementUp)
        {
            playerPos.y -= speed;
            filename = "squirrel-facing-up.png";
        }
        else if(direction.equals("down") && allowMovementDown)
        {
            playerPos.y += speed;
            filename = "squirrel-facing-down.png";
        }
        else if(direction.equals("left") && allowMovementLeft)
        {
            playerPos.x -= speed;
            filename = "squirrel-facing-left.png";
        }
        else if(direction.equals("right") && allowMovementRight)
        {
            playerPos.x += speed;
            filename = "squirrel-facing-right.png";
        }
    }

    public void playerShoot()
    {
        PlayerAcorn acorn = new PlayerAcorn(view, direction, playerPos.x, playerPos.y, state);
        state.addObject(acorn);
        state.addAcorn(acorn);
    }

    public void resetPlayerMovementStatus()
    {
        allowMovementDown = true;
        allowMovementLeft = true;
        allowMovementRight = true;
        allowMovementUp = true;
    }

    public Point getPlayerPosition()
    {
        return playerPos;
    }

    public int getPlayerWidth()
    {
        return width;
    }

    public int getPlayerHeight()
    {
        return height;
    }

}
