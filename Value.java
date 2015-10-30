import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

/**
 * Write a description of class Value here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Value extends UI
{

    private GreenfootImage img = getImage();
    public int value;
    public int targValue;
    private boolean b = true;

    public Value( int i  ){

        Create( i, 38.0f );

    }

    public Value( int i, float size ){

        Create( i, size );

    }

    private void Create( int i, float size ){

        img.scale( 80, 80 );
        Font f = img.getFont();
        f = f.deriveFont( size );
        img.setFont(f);
        img.drawString( ""+value, (""+value).length()* -10 + 38, 30 );
        targValue = i;

    }

    public void act() 
    {

        if( b ){

            atualize();
            img.clear();
            img.drawString( ""+value, (""+value).length()* -10 + 38, 30 );

        }

    }

    public void addPoints( int add ){

        targValue += add;
        b = true;

    }
    
    public void setPoints( int val ){
        
        value = val;
        b = true;
    
    }

    private void atualize(){

        if ( value < value + targValue ){

            value++;
            targValue--;

        }else if ( value > value + targValue && targValue != 0 ){

            value--;
            targValue++;

        }else{

            b = false;

        }

    }

}
