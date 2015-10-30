import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ammo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AmmoData extends DataConstructors
{

    //struct ammoDATA
    public int damage,
    interval,
    speed,
    facing,
    faceChange,
    width,
    wdChange,
    height,
    hgChange,
    volume;
    public boolean pircing,
    boundLimit;
    public String sound,
    name;
    public EffectData effect;
    public GreenfootImage image;

    public AmmoData( String id, int dmg, int velocity, int inter, boolean b, int deg, int degChange, int wd, int wdAlt, int hg, int hgAlt, boolean bl, String fileName, String filesound, int volum, EffectData sfx ){

        name = id;
        damage = dmg;
        interval = inter;
        speed = velocity;
        facing = deg;
        faceChange = degChange;
        width = wd;
        wdChange = wdAlt;
        height = hg;
        hgChange = hgAlt;
        volume = volum;
        pircing = b;
        image = new GreenfootImage( fileName );
        sound = filesound;
        effect = sfx;
        boundLimit =  bl;

    }
    
    public AmmoData( String id, int dmg, int velocity, int inter, boolean b, int deg, int wd, int hg, String fileName, String filesound, EffectData sfx ){

        name = id;
        damage = dmg;
        interval = inter;
        speed = velocity;
        facing = deg;
        faceChange = 0;
        width = wd;
        wdChange = 0;
        height = hg;
        hgChange = 0;
        volume = 60;
        pircing = b;
        image = new GreenfootImage( fileName );
        sound = filesound;
        effect = sfx;
        boundLimit = true;

    }

}
