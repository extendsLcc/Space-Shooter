import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Shot extends Ataques
{
    
    protected GreenfootImage img;
    protected AmmoData This;
    public Class < ? extends Units > cls;
    
    public static Shot create( AmmoData AD, Class < ? extends Units > clz ){
    
        if( AD.wdChange != 0 || AD.hgChange != 0 || AD.faceChange != 0  ) return new ProjectilEx( AD, clz );
        else return new Projectil( AD, clz );
    
    }

}