import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * New obstacle which ends the game if touched. Really unfair due to the shadow.
 * 
 * @author Ethan 
 * @version May 2024
 */
public class Barrel extends FallingObject
{
    public void hitGround() {
        world.createBarrel();
    }
}
