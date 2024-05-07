import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our glorious saviour, the Elephant.
 * 
 * @author Ethan 
 * @version April 2024
 */
public class Elephant extends SmoothMover
{
    double max_speed = 6;
    double friction = 0.3;
    double accel = 0.5;
    double velocity = 0;
    public void act()
    {
        int direction = (Greenfoot.isKeyDown("right") ? 1 : 0) - (Greenfoot.isKeyDown("left") ? 1 : 0);
        if (direction != 0)
            velocity += accel * direction;
            if (velocity > max_speed)
                velocity = max_speed;
            else if (velocity < -max_speed)
                velocity = -max_speed;
        else {
            double sign = Math.signum(velocity);
            velocity -= friction * sign;
            if ((sign > 0 && velocity < 0) || (sign < 0 && velocity > 0))
                velocity = 0;
        }
        move(velocity);
        
        if (isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
        }
    }
}
