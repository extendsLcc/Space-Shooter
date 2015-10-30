import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Write a description of class Ataques here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract public class Ataques extends Main
{
    
    public boolean fade = false;
    public List < Units > filt;
    
    protected void damage( int dmg, boolean pircing, EffectData effect, Class < ? extends Units > cls ){

        if( pircing ){
        
            damagePircing( dmg, effect, cls );
            return;
        
        }
        
        List < Units > enemies = getIntersectingObjects( cls );
        
        if ( !enemies.isEmpty() ){
            
            for ( Units u: enemies ){
                
                u.HP -= dmg;
                   
            }

            w.addObject( new SpriteEffect( effect ), getX(), getY() );
            fade = true;

        }

    }
    
    protected void damagePircing( int dmg, EffectData effect, Class < ? extends Units > cls ){
        
        List < Units > enemies = getIntersectingObjects( cls );
        
        for( int i = 0; i < enemies.size(); i++ ){
        
            if( filt.contains( enemies.get( i ) ) ){
            
                enemies.remove( enemies.get( i ) );
                i--;
            
            }
        
        }
        
        if ( !enemies.isEmpty() ){
            
            for ( Units u: enemies ){
                
                u.HP -= dmg;
                filt.add( u );
            
            }

            w.addObject( new SpriteEffect( effect ), getX(), getY() );

        }

    }
    
    public void lineDamage( int dmg, int x, int y, int x2, int y2, int radius, Class < ? extends Units > cls ){
        
        List < Units > l = new ArrayList < Units >();
        double deg = angleBetween( x, y, x2, y2 ),
        dist = distanceBetween( x, y, x2, y2 );
  
        for( int i = 0; i < dist; i+=25 ){           
            
            int tx = polarX( x, i, (int)deg ),
            ty = polarY( y, i, (int)deg );
            
            if ( tx <= 0 || ty <= 0 || tx >= w.getWidth()-1 || ty >= w.getHeight()-1 ) continue;
 
            for ( Units e : getObjectsInRangeXY( tx, ty , radius, cls ) ){
      
                l.add( e );
            
            }
            /*
            Dummy d = new Dummy();
            w.addObject(d, tx, ty );
            d.getImage().clear();
            d.getImage().scale( radius, radius );
            d.getImage().setColor( Color.WHITE );
            d.getImage().fillOval( 0, 0, radius, radius );
            */
            
        }
    
        for( Units e : l ){
        
            e.HP -= dmg;
        
        }
        
    }
     
}
