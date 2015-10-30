import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Projectil extends Shot
{

    /*private GreenfootImage img;
    private AmmoData This;
    public Class < ? extends Units > cls;*/

    public Projectil( AmmoData AD, Class < ? extends Units > clz ){

        This = AD;
        cls = clz;
        int tmp = Math.max( This.image.getWidth(), This.image.getHeight() );
        img = new GreenfootImage( tmp, tmp );
        img.drawImage( This.image, ( img.getWidth() - This.image.getWidth() ) / 2 , ( img.getHeight() - This.image.getHeight() ) / 2 );
        img.rotate( This.facing );
        img.scale( This.width, This.height );
        setImage( img );

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

        damage( This.damage, This.pircing, This.effect, cls );

    }

}