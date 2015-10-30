import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

public class Player extends Units
{
       
    //public int ammo = 1500;
    public int[] ammo = new int[10];
    public int Spammo = 50;
    public int specialShotInt = 60;
    public int shotInterval = 3;
    private int amIntv, missIntv;
    public int points;
    
    public AmmoData playerAmmo ;//= Ammos[1];     // ACTIVE BASIC AMMO
    List < AmmoData > playerAmmunition = new ArrayList< AmmoData >();
    
    /*-- INTERFACE --*/
    public Value ammoUI;
    public Icon ammoICO;
    public Value hpUI;
    public Icon hpICO;
    public Value SpammoUI;
    public Icon SpammoICO;
    
    protected void addedToWorld(World world){
        
        int tmpX = w.getWidth() - 35;
        getImage().scale( 120, 100 );
        HP = 200;
        ammoUI = new Value( 0 );
        ammoICO = new Icon( "Projectil.png", 45, 45 );
        hpUI = new Value( HP );
        hpUI.value = HP;
        hpICO = new Icon( "Life.png", 50, 52 );
        SpammoUI = new Value( Spammo );
        SpammoICO = new Icon( "charge.png", 50, 52 );
        world.addObject( ammoUI, tmpX, 600 );
        world.addObject( ammoICO, tmpX, 525 );
        world.addObject( hpUI, tmpX, 485 );
        world.addObject( hpICO, tmpX, 410 );
        world.addObject( SpammoUI, tmpX, 715 );
        world.addObject( SpammoICO, tmpX, 640 );
        
        ammoAdd( Ammos[0], 1500 );
        ammoAdd( Ammos[1], 100 );
        ammoAdd( Ammos[2], 50 );
        ammoChange( playerAmmunition.get( 0 ) );

    }
    
    public void act() 
    {
        
        if ( HP < 0 ) { die( Effects[6], 0 ); return;}
        
        movement();
        equipment();
        Shot();
        Special();
        //trail();
        if( HP != hpUI.value && hpUI.targValue == 0 )hpUI.addPoints( HP - hpUI.value );
        
    }
    
    private void Shot(){
        
        int index = playerAmmunition.indexOf( playerAmmo );
        
        if( Greenfoot.isKeyDown("space") && shotInterval > playerAmmo.interval && ammo[index] > 0 ){
        
            int f = getRotation();
            Shot p = Shot.create( playerAmmo, Inimigo.class );
            addObjectAtOffset( p, getX(), getY(), 70, f );
            p.setRotation( f );
            //!--------------!\\
            shotInterval = 0;
            ammo[index] --;
            ammoUI.addPoints( -1 );
        
        }
        
        shotInterval++;
        
    }
    
    private void Special(){
    
        if( Greenfoot.isKeyDown("r") && specialShotInt > 120 && Spammo > 0 ){
        
            addObjectAtOffset( new ChargeBeam( this ), getX(), getY(), 80, getRotation() );
            w.addObject( new CoolDown( ACT2SEC( 120 ) ), 845, 640 );
            Greenfoot.playSound( "Laser_Cannon.mp3" );
            //!--------------!\\
            specialShotInt = 0;
            shotInterval = -78;
            Spammo--;
            SpammoUI.addPoints( -1 );
        
        }  
        
        specialShotInt++;
        
    }
    
    private void equipment(){
    
        if( Greenfoot.isKeyDown("q") && amIntv > 20 ){
        
            ammoChange( playerAmmunition.get( nextIndex( playerAmmunition, playerAmmo, -1 ) ) );
            amIntv = 0;
            
        }else if( Greenfoot.isKeyDown("e") && amIntv > 20 ){
        
            ammoChange( playerAmmunition.get( nextIndex( playerAmmunition, playerAmmo, 1 ) ) );
            amIntv = 0;
        
        }
        
        amIntv++;
    
    }
    
    private int nextIndex( List < ? > l, Object o, int to ){
        
        int i = l.indexOf( o ) + to;
        if( i == l.size() ) return 0;
        return ( i < 0 ) ? l.size() - 1 : i ;
        
    }
    
    private void ammoChange( AmmoData ad ){
    
        ammoICO.setImage( ad.image );
        GreenfootImage i = ammoICO.getImage();
        i.scale( ( int ) ( ad.width * 1.75 ), ( int ) ( ad.height * 1.75 ) );
        playerAmmo = ad;
        ammoUI.setPoints( ammo[playerAmmunition.indexOf( ad )] );
    
    }
    
    public void ammoAdd( AmmoData ad, int quantidade ){
    
        playerAmmunition.add( ad );
        ammo[playerAmmunition.indexOf( ad )] = quantidade;
    
    }
    
    private void movement(){
        
        int x = getX(), y = getY(), dir = getRotation();
        
        if( Greenfoot.isKeyDown("left") && x > 10 ){
            
            setLocation( x - 7, y );
            setRotation( Math.max( dir - 2, 247 ) );
            starsDir();
            
        }else if( Greenfoot.isKeyDown("right") && x < 794){

            setLocation( x + 7, y );
            setRotation( Math.min( dir + 2, 293 ) );
            starsDir();
            
        }else {
            
            setRotation((int) Math.round( -( dir - 270 ) / 1.8 )  + dir );
            starsDir();
            
        }
        
        x = getX();
        
        if( Greenfoot.isKeyDown("up") && y > 70)
        {
            setLocation( x, y - 7 );
            
        }else if( Greenfoot.isKeyDown("down") && y < 660 ){
            
            setLocation( x, y + 7 );
            
        }
    
    }
    
    void trail(){
    
        addObjectAtOffset( new Trail(), getX(), getY(), 55, getRotation()-165 );
        addObjectAtOffset( new Trail(), getX(), getY(), 55, getRotation()-180 );
    
    }
    
    private void starsDir(){
    
        for( Star s : ( List<Star> ) w.getObjects( Star.class ) ){
        
            s.setRotation( this.getRotation() - 180 );
        
        }
    
    }

}
