import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label label = new Label("Hungry Elephant", 60);
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(label, 300, 200);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("space")) {
            MyWorld newWorld = new MyWorld();
            Greenfoot.setWorld(newWorld);
        }
    }
}
