import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ammo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Icon extends UI
{
    
    public Icon( String img, int width, int height ){
        
        setImage( img );
        getImage().scale( width, height );
    
    }
    
    public void act() 
    {
    }
    
}
