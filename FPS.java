import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FPS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FPS extends Actor
{

    private static int acts;
    private static long lasttime;
    private static double fps;
    
    public FPS(){
    
        getImage().clear();
    
    }
    
    public double getFPS(){
    
        return fps;
    
    }
    
    public void act(){
    
        acts++;
        long time = System.currentTimeMillis();
        
        if( time >= lasttime + 1000){
        
            fps =  acts;
            lasttime = time;
            acts = 0;
        
        }
    
    }
    
}