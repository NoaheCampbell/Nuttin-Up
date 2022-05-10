import java.awt.Graphics;
import java.awt.Point;

public class Mirror implements Moveable
{
    private Point position;
    private GameView view;
    private String filename;
    private GameState state;
    private int width;
    private int height;
    
    public Mirror(Point position, GameView view, GameState state)
    {
        this.position = position;
        this.view = view;
        filename = "acorn.png";
        this.state = state;
        width = 50;
        height = 50;
    }

    public void update() 
    {
        for(PlayerAcorn acorn : state.getAcorns())
        {
            Point acornPos = acorn.getAcornPosition();
            int acornWidth = acorn.getAcornWidth();
            int acornHeight = acorn.getAcornHeight();

            if(state.isCollision(acornPos, position, acornWidth, acornHeight))
            {
                acorn.setAcornSpeed(-acorn.getAcornSpeed());
            }
        }
    }

    public void draw(Graphics g) 
    {
        view.drawOffSet(width, height, position.x, position.y, g, filename);
    }
}
