import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class SpriteEffect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpriteEffect extends SpecialEffect
{
    
    private EffectData This;
    private long time;
    private int frame = 0;
    
    public SpriteEffect( EffectData ed ){
    
        This = ed;
        time = System.currentTimeMillis();
        getImage().clear();
        setImage( This.sprites.get( frame ) );
        
    }
    
    public void act(){
    
        if ( System.currentTimeMillis() - time >= This.timer ){
        
            time = System.currentTimeMillis();
            frame++;
            
            if ( frame < This.sprites.size() ){
            
                setImage( This.sprites.get( frame ) );
                
                if( This.alpha != 100 ) getImage().setTransparency( This.alpha );
                
            }else if( This.loop ){
            
                frame = 0;
            
            }else  w.removeObject( this );
        
        }
    
    }
    
}
