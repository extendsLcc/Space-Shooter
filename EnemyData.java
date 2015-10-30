import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_Data here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyData extends DataConstructors
{

    public int hp,
    pbounty,
    width,
    height,
    face,
    distOrig,
    degOrig,
    levelAI;
    String apparence,
    name;
    public AmmoData[] AD;
    public EffectData ED;

    public EnemyData( String id, int life, int bounty, int facing, int wd, int hg, int dist, int deg, int AIlvl, String img, AmmoData[] amd, EffectData ed ){

        id = name;
        hp = life;
        pbounty = bounty;
        width = wd;
        height = hg;
        face = facing;
        distOrig = dist;
        degOrig = deg;
        levelAI = AIlvl;
        apparence = img;
        AD = amd;
        ED = ed;

    }

}
