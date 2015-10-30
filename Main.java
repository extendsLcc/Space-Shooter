import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class API here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */ 

abstract public class Main/*_Functions*/ extends Actor
{

    // 18 FPS
    //public static final double FPS = 13.5;
    public static World w;
    public static FPS fps;
    
    //---
    static final Dummy dummy = new Dummy();
    
    //----------------------------------------------
    //              Number API
    //----------------------------------------------
    
    public double ACT2SEC( double act ){
        
        return act / fps.getFPS();
        
    }
    
    public double SEC2ACT( double act ){
        
        return act * fps.getFPS();
    
    }
    
    public static int Random( int min, int max ){
    
        return Greenfoot.getRandomNumber( max + 1 ) + min;
    
    }
    
    public void dbg( String s ){
    
        //JOptionPane.showMessageDialog( null, s, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE );
        System.out.println(s);
    
    }
    
    public void playVolume( String arquivo, int volume ){

        GreenfootSound s = new GreenfootSound( arquivo );
        s.setVolume( volume );
        s.play();

    }
    
    //----------------------------------------------
    //              Colision
    //----------------------------------------------
    
    public <T extends Actor> List<T> getObjectsInRangeXY( int x, int y, int r, Class<T> cls ){
    
        dummy.setLocation( x, y );
        return dummy.getObjectsinRangeC( r, cls );
    
    }
    
    public List getObjectsAtRange( int radius, Class cls){
    
        return getObjectsInRange( radius, cls );
    
    }
    
    //----------------------------------------------
    //              Trigonometric API
    //----------------------------------------------
    
    public double distanceBetween( int x1, int y1, int x2, int y2 ){
    
        return Math.sqrt( Math.pow( x2 - x1, 2) + Math.pow( y2 - y1, 2 ) );
    
    }
    
    public double angleBetween( int x1, int y1, int x2, int y2 ){
        
        return Math.toDegrees( Math.atan2( y2 - y1, x2 - x1 ) ); 
        
    }
    
    public int diferenceBetweenAngles( int deg1, int deg2 ){
    
        int t = Math.abs( deg1 - deg2 ) % 360;
        if ( t > 180 ) t = 360 - t;
        return t;
    
    }
    
    public int polarX( int x, int dist, int deg ){
    
        return (int) ( x + Math.round( dist *  Math.cos( Math.toRadians( deg ) ) ) );
    
    }
    
    public int polarY( int y, int dist, int deg ){
    
        return (int) ( y + Math.round( dist *  Math.sin( Math.toRadians( deg ) ) ) );
        
    }
    
    public void setLocationOffset( int dist, int deg ){
    
        setLocationOffset(this.getX(), this.getY(), dist, deg );
        
    }
    
    public void setLocationOffset( int x, int y, int dist, int deg ){
    
        setLocation( polarX( x, dist, deg ), polarY( y, dist, deg ) );
        
    }
    
    public void addObjectAtOffset( Actor a, int x, int y, int dist, int deg ){
    
        w.addObject( a, polarX( x, dist, deg ), polarY( y, dist, deg ) );
    
    }
    
    //----------------------------------------------
    //              DataBase Init
    //----------------------------------------------
    
    public static EnemyData[] Enemies = new EnemyData[ 10 ];
    public static AmmoData[] Ammos = new AmmoData[ 10 ];
    public static EffectData[] Effects = new EffectData[ 10 ];
    public static BuffData[] Buffs = new BuffData[ 10 ];
    
    public static void CreateDB(){
    
        generateEffects();
        generateBuffs();
        generateAmmos();
        generateEnemies();
    
    }
    
    public static void generateEffects(){
    
        //Effects[0] = new EffectData( 5, Sprite.getSprites( new GreenfootImage( "t.png" ), 256, 256, 200, 200 ), false, "" );
        Effects[1] = new EffectData( 50, Sprite.getSprites( new GreenfootImage( "explo.png" ), 96, 96, 100, 100 ), false, "" );
        Effects[2] = new EffectData( 3, Sprite.getSprites( new GreenfootImage( "Exp_type_C.png" ), 256, 256, 50, 50 ), false, "" );
        //Effects[3] = new EffectData( 3, Sprite.getSprites( new GreenfootImage( "explosion_D.png" ), 256, 256, 600, 600 ), false, "" );
        Effects[4] = new EffectData( 3, Sprite.getSprites( new GreenfootImage( "Cloud_explosion.png" ), 256, 256, 100, 100 ), false, "" );
        Effects[5] = new EffectData( 400, Sprite.getSprites( new GreenfootImage( "Shield.png" ), 256, 256, 200, 200 ), true,  100, 0, 0, 0, 0, "", 0 );
        Effects[6] = new EffectData( 3, Sprite.getSprites( new GreenfootImage( "Exp_type_B.png" ), 192, 192, 250, 250 ), false, "" );
        Effects[7] = new EffectData( 50, Sprite.getSprites( new GreenfootImage( "ShieldHit.png" ), 256, 256, 200, 200 ), false,  80, 0, 0, 0, 0, "", 0 );
        //
        Effects[8] = new EffectData( 30, Sprite.getSprites( new GreenfootImage( "Exp_type_A.png" ), 128, 128, 200, 200 ), false, "" );
        
    }
    
    public static void generateAmmos(){ // requires Effects
        
        Ammos[0] = new AmmoData( "Basic", 2, 8, 10, false, 90, 20, 20, "Projectil.png", "Laser_Shot_1.mp3", Effects[4] );
        Ammos[1] = new AmmoData( "Pircing", 10, 15, 20, true, 90, 100, 10, "piercingBeam.png", "Laser_Shot_1.mp3", Effects[4] );
        Ammos[2] = new AmmoData( "Ball", 10, 8, 15, false, 0, 30, 25, "ball.png", "Laser_Shot_1.mp3", Effects[4] );
        Ammos[3] = new AmmoData( "Basic", 9999, 0, 10, false, 90, 0, 20, 0, 20, 0, false, "Projectil.png", "", 60, Effects[4] );
        
    }
    
    public static void generateBuffs(){ //requires Effects
    
        Buffs[0] = new BuffData( 5, new EffectData[] { Effects[5] }, Buff.sphreeShield.class );
        Buffs[1] = new BuffData( 5, new EffectData[] {}, Buff.spiningShield.class );
    
    }
    
    public static void generateEnemies(){ // requires Effects, Ammos
    
        //Enemies[0] = new EnemyData( "inimigo1", 18, 5, 180, 120, 120, 10, 0, 0, "nav_inimiga_lcc3.png", new AmmoData[]{ Ammos[0]}, Effects[6] );
        //Enemies[1] = new EnemyData( "inimigo1", 50, 20, 180, 120, 120, 10, 0, 0, "nav_inimiga_lcc2.png", new AmmoData[]{ Ammos[0]}, Effects[6] );
        Enemies[1] = new EnemyData( "Teste", 10000, 500, 0, 50, 50, 40, 90, 0, "skull.png", new AmmoData[]{ Ammos[0], Ammos[2] }, Effects[6] );
        
    }

}

/*
 * 
        public static ArrayList<AmmoData> AmmoData2 = new ArrayList<AmmoData>();
        
        AmmoData umAmo = new AmmoData( "Basic", 2, false, 0, 0, 0, -1, 20, 0, 20, 0, "Projectil.png", "Laser_Shot_1.mp3", 60, Impact.class );
        AmmoData2.add( umAmo );
        AmmoData2.size();
        AmmoData oMesmoAmo = AmmoData2.get( 0 );*/