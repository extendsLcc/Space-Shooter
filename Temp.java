import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Temp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Temp extends Main
{
  
    public void addedToWorld( World world ){
        
        /*for( int i = 0; i < 800; i+=60 ){
        
            for ( int x = 0; x < 400; x+=56 ){
            
                world.addObject( new Inimigo( Enemies[1] ), i, x );
            
            }
        
        }*/
        world.addObject( new Inimigo( Enemies[1] ), getX(), getY() );
        world.removeObject(this);

    }
    
}
