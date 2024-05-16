import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent of gravity affected objects.
 * 
 * @author Ethan 
 * @version May 2024
 */
public abstract class FallingObject extends SmoothMover
{
    double gravity = 0;
    double gravityScale = 0.03;
    MyWorld world;
    
    public void addedToWorld(World world) {
        this.world = (MyWorld) world;
    }
    
    public void act()
    {
        gravity += gravityScale;
        setLocation(getExactX(), getExactY() + gravity);
        if (getExactY() >= world.getHeight() - 1)
            hitGround();
    }
    
    public void setGravityScale(double newScale) {
        gravityScale = newScale;
    }
    
    public double getGravityScale() {
        return gravityScale;
    }
    
    public abstract void hitGround();
}
