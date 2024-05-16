import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main objective of the game. Ends the game if it hits the floor.
 * 
 * @author Ethan 
 * @version May 2024
 */
public class Apple extends FallingObject
{
    public void hitGround() {
        world.gameOver();
    }
}
