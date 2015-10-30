import greenfoot.GreenfootImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a description of class Buff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class BuffData extends DataConstructors 
{

    public int timer;
    public ArrayList< EffectData > effects;
    public Class < ? extends BuffEffect> clz;
    
    public BuffData( int interval, EffectData[] effect, Class < ? extends BuffEffect > cls )
    {
        
        timer = interval;
        effects = new ArrayList ( Arrays.asList( effect ) );
        clz = cls;
        
    }
    
}
