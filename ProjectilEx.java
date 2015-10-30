import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ProjectilEx here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectilEx extends Shot
{
    
    /*private GreenfootImage img;
    private AmmoData This;
    public Class < ? extends Units > cls;*/

    public ProjectilEx( AmmoData AD, Class < ? extends Units > clz ){

        This = AD;
        cls = clz;
        //setImage( This.imgfile );
        img = getImage();
        img.scale( This.width, This.height );
        img.rotate( This.facing );

        if( This.sound != "" ){

            playVolume( This.sound, This.volume );

        }
        
        if( This.pircing ){
        
            filt = new ArrayList<Units>();
            
        }

    }
    
    public void act() 
    {

        if ( fade ) { 

            w.addObject( new SpriteEffect( This.effect ), getX(), getY() );
            w.removeObject( this );
            return; 

        }

        int x = getX() , y = getY();

        if( y > 0 && y < w.getHeight()-1 && x > 0 && x < w.getWidth()-1 ){

            setLocationOffset( This.speed, getRotation() );

        }else if( This.boundLimit ){

            w.removeObject( this );
            return;

        }

        if ( This.faceChange != 0 ){

            turn( This.faceChange );

        }

        if ( This.wdChange != 0 || This.hgChange != 0 ){

            img.scale( img.getHeight() + This.wdChange, img.getHeight() + This.hgChange );

        }

        damage( This.damage, This.pircing, This.effect, cls );

    }

}
