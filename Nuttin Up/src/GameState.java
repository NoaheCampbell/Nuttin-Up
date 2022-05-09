import java.util.ArrayList;
import java.awt.Graphics;

public class GameState 
{
    private ArrayList<Moveable> objects;
    private ArrayList<Moveable> objectsToAdd;
    private ArrayList<Moveable> objectsToRemove;
    private Player player;

    public GameState()
    {
        objects = new ArrayList<Moveable>();
        objectsToAdd = new ArrayList<Moveable>();
        objectsToRemove = new ArrayList<Moveable>();
    }

    public void addObject(Moveable object)
    {
        objectsToAdd.add(object);
    }

    public void removeObject(Moveable object)
    {
        objectsToRemove.add(object);
    }

    public void updateAll()
    {
        for (Moveable object : objects)
        {
            object.update();
        }

        objects.addAll(objectsToAdd);
        objects.removeAll(objectsToRemove);

        objectsToAdd.clear();
        objectsToRemove.clear();
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

}
