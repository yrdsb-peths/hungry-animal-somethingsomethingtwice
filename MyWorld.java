import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game World.
 * 
 * @author Ethan 
 * @version April 2024
 */
public class MyWorld extends World
{
    int score = 0;
    int level = 1;
    Label scoreLabel;
    Elephant elephant;
    Apple apple;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        scoreLabel = new Label(score, 30);
        elephant = new Elephant();
        addObject(scoreLabel, 15, 15);
        addObject(elephant, 300, 300);
        createApple();
    }
    
    public void updateScore()
    {
        scoreLabel.setValue(score);
        String str = String.valueOf(score);
        scoreLabel.setLocation(15 * str.length(), 15);
    }
    
    public void createApple()
    {
        apple = new Apple();
        apple.setGravityScale(0.01 * Math.min(level, 7));
        addObject(apple, 32 + Greenfoot.getRandomNumber(600 - 32 - 32), 0);
    }
    
    public void gameOver()
    {
        removeObject(elephant);
        removeObject(apple);
        scoreLabel.setSize(40);
        scoreLabel.setLocation(getWidth() / 2, getHeight() / 2 + 20);
        
        Label gameOverLabel = new Label("Game Over", 40);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2 - 20);
    }
}
