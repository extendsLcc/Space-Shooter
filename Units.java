import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

abstract public class Units extends Main
{

    public List < Buff > buffs =  new ArrayList<Buff>();
    public int HP = 1;
    
    public void die( EffectData ed, int b ){
    
        w.addObject( new SpriteEffect( ed ), getX(), getY() );
        w.removeObject( this );
        
    }
    
}
