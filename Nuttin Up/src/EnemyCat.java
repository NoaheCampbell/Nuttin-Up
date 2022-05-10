import java.awt.Graphics;
import java.awt.Point;

public class EnemyCat implements Moveable
{
    private Point position;
    private String filename;
    private GameView view;
    private GameState state;
    private int width;
    private int height;
    private Player player;

    public EnemyCat(Point position, GameView view, GameState state, String direction, Player player)
    {
        this.position = position;
        this.view = view;
        this.state = state;
        filename = "enemy-cat-" + direction + ".png";
        width = 70;
        height = 70;
        this.player = player;
    }

    public void update() 
    {
        for(PlayerAcorn acorn : state.getAcorns())
        {
            Point acornPosition = acorn.getAcornPosition();
            int acornWidth = acorn.getAcornWidth();
            int acornHeight = acorn.getAcornHeight();

            if(state.isCollision(acornPosition, position, acornWidth, acornHeight))
            {
                state.removeAcorn(acorn);
                state.removeObject(acorn);
                state.removeObject(this);
            }
        }

        if(state.isCollision(player.getPlayerPosition(), position, player.getPlayerWidth(), player.getPlayerHeight()))
        {
            state.removeObject(player);
            state.setGameOver(true);
            state.removeObject(this);
        }
        
    }

    public void draw(Graphics g) 
    {
        view.drawOffSet(width, height, position.x, position.y, g, filename);
    }

    
    
}
