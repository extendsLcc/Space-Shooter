import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class t here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempoTeste extends Actor
{
    /**
     * Act - do whatever the t wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private long i;
    private boolean b = true;

    private List < GreenfootImage > l;
    private int img = 0;
    private boolean fade = false;

    public TempoTeste(){
        //l = Sprite.getSprites( new GreenfootImage( "explo.png" ), 0, 0, 96, 96, 15, 100, 100 );
        //l = Sprite.getSprites( new GreenfootImage( "Exp_type_B.png" ), 0, 0, 192, 192, 64, 300, 300 );
        //l = Sprite.getSprites( new GreenfootImage( "Exp_type_C.png" ), 256, 256, 400, 400 );
        //l = Sprite.getSprites( new GreenfootImage( "t.png" ), 256, 256, 200, 200 );
        //l = Sprite.getSprites( new GreenfootImage( "tst.png" ), 528, 528, 800, 800  );
        //l = Sprite.getSprites( new GreenfootImage( "ShieldHit.png" ), 256, 256, 200, 200 );
        //l = Sprite.getSprites( new GreenfootImage( "explosion.png" ), 458, 458, 200, 200 );
    }

    public void addedToWorld(World world){

        world.addObject( new SpriteEffect( Main.Effects[8] ),getX(),getY() );
        world.removeObject( this );
        
    }

    public void act() 
    {

        if( b ){

            b = false;
            i = System.currentTimeMillis();

        }

        if ( System.currentTimeMillis() - i >= 50 && !fade){

            i = System.currentTimeMillis();
            getImage().clear();
            setImage( l.get( img ) );
            img++;
            if( img == l.size() ) img = 0;//fade = true;

        }

        if ( fade ){

            getImage().setTransparency( getImage().getTransparency() - 5 );
            setLocation( getX(), getY()- 1 );

            if( getImage().getTransparency() < 40 ){

                getWorld().removeObject( this );

            }

        }

    }    
}
