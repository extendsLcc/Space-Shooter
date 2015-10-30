import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Trail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trail extends Actor
{
    
    public Trail(){
    
        GreenfootImage i = getImage();
        i.clear();
        i.setColor( Color.BLUE );
        i.fillRect( 0, 0, 50, 3 );
        i.rotate(90);
        i.setTransparency( 150 );
    
    }
    
    public void addedToWorld( World world ){
        
        Units u = (Units) world.getObjects( Player.class ).get(0);
        setRotation( u.getRotation() - 180 );
        
    }
    
    public void act() 
    {
        
        move( 1 );
        GreenfootImage i = getImage();
        i.setTransparency( i.getTransparency()-5 );
        if( i.getTransparency() < 10 ){
        
            getWorld().removeObject( this );
        
        }
        
    }    
    
}
