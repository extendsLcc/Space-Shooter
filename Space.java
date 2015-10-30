import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * 
 * 
 */
public class Space extends World
{

    private static final Class<?>[] ORDEM_DOS_ATORES = { UI.class, SpecialEffect.class, Units.class, Ataques.class };
    //---

    public Space(){

        super( 880, 720, 1);
        setPaintOrder( ORDEM_DOS_ATORES );
        Greenfoot.setSpeed( 51 );

        GreenfootImage bg = new GreenfootImage(880, 720);
        bg.setColor( Color.BLACK );
        bg.fill();
        setBackground( bg );

        Main.w = this;
        Main.fps = new FPS();
        Main.CreateDB();
        addObject( Main.dummy, 0, 0 );
        addObject( Main.fps, 10, 0 );
        addObject( new Background(), 845, 340 );
        Player r = new Player();
        addObject( r, 400, 620 );
        r.setRotation( 270 );
        
        for ( int i = 0; i < 0; i++ ){

            Inimigo e = new Inimigo( Main.Enemies[1] );
            addObject( e, Main.Random( 0, 670 ), Main.Random( 0, 500 )  );

        }

        for( int i = 200; i > 0; i-- ){

            addObject( new Star( Main.Random( 2, 3 ), Main.Random( 1, 4 ) ), Main.Random(0,800), Main.Random(0,715) );

        }

    }

}

/* 
private static int speed = 1;
private GreenfootImage scroll;
private int sp;     
GreenfootImage bg = new GreenfootImage( "space1.jpg" );
scroll = new GreenfootImage(880, 720);

for(int x = 0; x < 880; x += bg.getWidth()) {

for(int y = 0; y < 720; y += bg.getHeight()) {

scroll.drawImage(bg, x, y);

}

}
public void acts(){

if ( sp >= 720 ) {

sp = 0;

}

sp += speed;
GreenfootImage bgi = getBackground();
bgi.drawImage( scroll, 0, sp );
bgi.drawImage( scroll, 0, sp - 720 );

}*/
