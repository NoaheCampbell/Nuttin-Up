import java.awt.Graphics;

public class MapLoader implements Moveable
{
    private int level;
    private boolean levelComplete;

    public MapLoader()
    {
        level = 1;
        levelComplete= false;
    }

    public void update()
    {
        if(levelComplete)
            level++;
    }

    public void draw(Graphics g)
    {
        g.drawImage(ResourceLoader.getLoader().getImage("map" + level + ".png"), 0, 0, 800, 800, null);
    }

    public boolean getLevelComplete()
    {
        return levelComplete;
    }

    public void setLevelComplete(boolean status)
    {
        levelComplete = status;
    }

    public int getLevelCount()
    {
        return level;
    }

    public void addLevelCount()
    {
        level++;
    }
}
