import greenfoot.GreenfootImage;
import java.util.List;

public class EffectData extends DataConstructors 
{

    // struct EffectData
    public int timer,
    wChange,
    hChange,
    wMax,
    hMax,
    alpha,
    alphaChange,
    volume;
    public boolean loop;
    public String sound;
    public List < GreenfootImage > sprites;
    
    public EffectData( int tm, List < GreenfootImage > s, boolean isloop, int ap, int wc, int hc, int wm, int hm, String sfile, int vol ){
    
        timer = tm;
        sprites = s;
        loop = isloop;
        alpha = ap;
        alphaChange = alpha;
        wChange = wc;
        hChange = hc;
        wMax = wm;
        hMax = hm;
        sound = sfile;
        volume = vol;
    
    }
    
    /**
     *      Versão compacta; 
    */
    
    public EffectData( int tm, List < GreenfootImage > s, boolean isloop, String sfile ){
    
        timer = tm;
        sprites = s;
        loop = isloop;
        alpha = 100;
        alphaChange = 0;
        wChange = 0;
        hChange = 0;
        wMax = 0;
        hMax = 0;
        sound = sfile;
        volume = 60;
    
    }
    
}
