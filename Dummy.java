import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Dummy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dummy extends Actor
{
    
    public Dummy(){
    
        getImage().clear();
    
    }
    
    public < T extends Actor > List < T > getObjectsinRangeC( int r, Class < T > cls ){
        
        return getObjectsInRange( r, cls );
        
    }
 
}
