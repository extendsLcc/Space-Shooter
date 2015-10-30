import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inimigo extends Units
{
    
    public EnemyData This;
    public AmmoData[] AD;
    private int v = 1;
    private long l = System.currentTimeMillis();
    
    public Inimigo(  EnemyData ED ){
        
        This = ED;
        HP = This.hp;
        setImage( This.apparence );
        getImage().scale( This.width, This.height );
        getImage().rotate( This.face );
        
    }
    
    public void act() 
    {
        
        if ( HP <= 0 ) {
            
            die( This.ED, This.pbounty );
            return;
            
        }
        
        if( getX() <= 30 ){
        
            //setRotation( 0 );
            v = 1;
        
        }else if ( getX() >= 755  ){
        
            //setRotation( 180 );
            v = -1;
        
        }
        
        setLocation( getX()+v, getY() );
        
    }
    
}
