import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Point;

public class GameState 
{
    private ArrayList<Moveable> objects;
    private ArrayList<Moveable> objectsToAdd;
    private ArrayList<Moveable> objectsToRemove;
    private ArrayList<PlayerAcorn> acorns;
    private ArrayList<PlayerAcorn> acornsToAdd;
    private ArrayList<PlayerAcorn> acornsToRemove;
    private Player player;
    private MapLoader mapLoader;
    private boolean levelCompleted;
    private boolean gameOver;
    private GameView view;

    public GameState(MapLoader mapLoader)
    {
        objects = new ArrayList<Moveable>();
        objectsToAdd = new ArrayList<Moveable>();
        objectsToRemove = new ArrayList<Moveable>();
        acorns = new ArrayList<PlayerAcorn>();
        acornsToAdd = new ArrayList<PlayerAcorn>();
        acornsToRemove = new ArrayList<PlayerAcorn>();
        this.mapLoader = mapLoader;
        levelCompleted = false;
        gameOver = false;
    }

    public ArrayList<PlayerAcorn> getAcorns()
    {
        return acorns;
    }

    public void addObject(Moveable object)
    {
        objectsToAdd.add(object);
    }

    public void removeObject(Moveable object)
    {
        objectsToRemove.add(object);
    }

    public void addAcorn(PlayerAcorn acorn)
    {
        acornsToAdd.add(acorn);
    }

    public void removeAcorn(PlayerAcorn acorn)
    {
        acornsToRemove.add(acorn);
    }

    public void updateAll()
    {
        for (Moveable object : objects)
        {
            object.update();
        }

        objects.addAll(objectsToAdd);
        objectsToAdd.clear();

        objects.removeAll(objectsToRemove);
        objectsToRemove.clear();

        acorns.addAll(acornsToAdd);
        acornsToAdd.clear();

        acorns.removeAll(acornsToRemove);
        acornsToRemove.clear();

        if(levelCompleted)
            mapLoader.setLevelComplete(true);

        if(gameOver)
        {
            player = new Player(view, "squirrel-facing-right.png", this);
            addObject(player);
            gameOver = false;
        }

    }

    public void drawAll(Graphics g)
    {
        for (Moveable object : objects)
        {
            object.draw(g);
        }
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public void movePlayer(String direction)
    {
        player.movePlayer(direction);
    }

    public void playerShoot()
    {
        player.playerShoot();
    }

    public Boolean isCollision(Point point1, Point point2, int width, int height)
    {
        if(point1.x >= (point2.x - width / 2) && point1.y >= (point2.y - height / 2) &&
            point1.x <= (point2.x + width / 2) && point1.y <= (point2.y + height / 2))
            return true;
        else
            return false;
    }

    public boolean getGameOver()
    {
        return gameOver;
    }

    public void setGameOver(boolean status)
    {
        gameOver = status;
    }

    public void setGameView(GameView view)
    {
        this.view = view;
    }

}
