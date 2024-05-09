import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends SmoothMover
{
    double gravity = 0;
    public void act()
    {
        gravity += 0.03;
        setLocation(getExactX(), getExactY() + gravity);
        MyWorld world = (MyWorld) getWorld();
        if (getExactY() >= world.getHeight() - 1)
            world.gameOver();
    }
}
