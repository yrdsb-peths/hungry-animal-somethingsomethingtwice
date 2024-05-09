import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Our glorious saviour, the Elephant.
 * 
 * @author Ethan 
 * @version April 2024
 */
public class Elephant extends SmoothMover
{
    double maxSpeed = 6;
    double friction = 0.3;
    double accel = 0.5;
    double velocity = 0;
    int imageIndex = 0;
    boolean facingLeft = false;
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    GreenfootSound sfxCollect = new GreenfootSound("elephantcub.mp3");
    
    public Elephant() {
        for (int i = 0; i < idleRight.length; i++) {
            idleRight[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            idleRight[i].scale(100, 90);
            idleLeft[i] = new GreenfootImage(idleRight[i]);
            idleLeft[i].mirrorHorizontally();
        }
    }
    
    public void animate() {
        if (!facingLeft)
            setImage(idleRight[imageIndex]);
        else
            setImage(idleLeft[imageIndex]);
        imageIndex = (imageIndex + 1) % idleRight.length;
    }
    
    public void act()
    {
        int direction = (Greenfoot.isKeyDown("right") ? 1 : 0) - (Greenfoot.isKeyDown("left") ? 1 : 0);
        if (direction != 0) {
            velocity += accel * direction;
            if (velocity > maxSpeed)
                velocity = maxSpeed;
            else if (velocity < -maxSpeed)
                velocity = -maxSpeed;
            facingLeft = direction < 0;
        } else {
            double sign = Math.signum(velocity);
            velocity -= friction * sign;
            if ((sign > 0 && velocity < 0) || (sign < 0 && velocity > 0))
                velocity = 0;
        }
        attemptExactMove();
        animate();
        
        if (isTouching(Apple.class)) {
            sfxCollect.stop();
            sfxCollect.play();
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.score++;
            world.updateScore();
            world.createApple();
        }
    }
    
    public void attemptExactMove() {
        World world = getWorld();
        double newX = getExactX() + velocity;
        if (newX <= 0) {
            velocity = 0;
            setLocation(0, getExactY());
        } else if (newX >= world.getWidth() - 1) {
            velocity = 0;
            setLocation(world.getWidth() - 1, getExactY());
        } else
            setLocation(newX, getExactY());
    }
}
