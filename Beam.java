import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.collision.CollisionChecker;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Beam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beam extends ChargeBeam
{

    private GreenfootImage img = getImage();
    private int c = 1;

    public Beam(){

        img.scale( 48, 230 );

    }

    public void act() 
    {

        if( img.getHeight() < 1300 ){

            c += 48;
            img.scale( 48 , img.getHeight() + 100 );
            lineDamage( 100, polarX( getX(), 80, getRotation()+90 ),  polarY( getY(), 80, getRotation()+90 ), polarX( getX(), c, getRotation()-90 ), polarY( getY(), c, getRotation()-90 ), 60, Inimigo.class );

        }else if ( img.getTransparency() > 40 ){

            img.setTransparency( Math.max( img.getTransparency() - 3, 0 ) );
            lineDamage( 50, polarX( getX(), 80, getRotation()+90 ),  polarY( getY(), 80, getRotation()+90 ), polarX( getX(), c, getRotation()-90 ), polarY( getY(), c, getRotation()-90 ), 60, Inimigo.class );

        }else{

            w.removeObject(this);

        }

    }

}
