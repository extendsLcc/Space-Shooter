import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Star extends Eviroment
{

    private int x;
    private int z;
    
    public Star( int size, int spd ){
    
        x = size;
        z = spd;
        setImage( new GreenfootImage( 30, 30 ) );
        getImage().setColor( Color.WHITE );
        getImage().fillOval( 0, 0, 15, 15 );
        getImage().scale( x, x );
        setRotation( 90 );
        
    }
    
    public void act() 
    {
        
        move(z);
        int x1 = getX();
        
        if( getY() >= w.getHeight() - 2 ){
        
            setLocation( x1, 0 );
        
        }
        
        if( x1 < 5 ){
        
            setLocation( w.getWidth() - 80, getY() );
        
        }
        
        if( x1 > 800 ){
        
            setLocation( 5, getY() );
        
        }
        
    }
    
}
