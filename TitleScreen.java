import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start screen.
 * 
 * @author Ethan 
 * @version May 2024
 */
public class TitleScreen extends World
{
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            MyWorld newWorld = new MyWorld();
            Greenfoot.setWorld(newWorld);
        }
    }
    
    private void prepare()
    {
        Label label = new Label("Hungry Elephant", 60);
        addObject(label,264,48);
        Label label2 = new Label("Move using Arrow Keys", 30);
        addObject(label2,200,96);
        Label label3 = new Label("Don't let the apple fall to the bottom!", 30);
        addObject(label3,304,128);
        Label label4 = new Label("Dodge the barrel!", 30);
        addObject(label4,161,160);
        Label label5 = new Label("Press Space to start", 30);
        addObject(label5,416,263);
        TitleElephant titleElephant = new TitleElephant();
        addObject(titleElephant,120,263);
    }
}
