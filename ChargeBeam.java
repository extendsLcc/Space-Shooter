import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class ChargeBeam extends Ataques
{

    private int i = 0,
    wd,
    h,
    a; 
    private Units u;
    
    public ChargeBeam(){}
    
    public ChargeBeam( Units unit ){
    
        getImage().scale( 63, 70 );
        u = unit;
        
    }
    
    public void act() 
    {
        
        GreenfootImage img = getImage();
        wd = img.getWidth();
        h = img.getHeight();
        a = img.getTransparency();
        
        if ( wd > 19 && i == 0 ){
        
            turn( 12 );
            img.scale( wd - 1, h - 1 );
            stickonRocket();
        
        }else if( i == 0 ){
            
            img = new GreenfootImage("Sphree.png");
            setImage( img );
            img.scale( 34, 34 );
            i = 1;
            Actor a = new Beam();
            int f = u.getRotation();
            addObjectAtOffset( a, getX(), getY(), 80, f );
            a.setRotation( f+90 );
            
        }else if ( img.getWidth() < 290 && i == 1 ){
            
            setImage( "Sphree.png" );
            img = getImage();
            img.scale( wd + 10, h + 10 );
            img.setTransparency( a - 9 );
            turn(15);
        
        }else if ( i == 1 ){
        
            w.removeObject( this );
        
        }
        
    }
    
    private void stickonRocket(){
        
        if( u.getWorld() != null ){
                
            setLocationOffset( u.getX(), u.getY(), 80, u.getRotation() );
         
        }
    
    }
    
}
