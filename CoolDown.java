import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

public class CoolDown extends UI
{

    // 18 FPS
    // 360/1  em 20 sec
    // 3240 acts 180 sec - erro 10 segundos
    private int timer;
    private double incr;
    private double interval;
    // EX
    private int R = 140, G = 140, B = 140, A = 55, ad = 1;
    
    public CoolDown( double secs ){    
        
        incr = (double) 360 / Math.max( SEC2ACT( secs ), 1);
        interval = incr;
        getImage().scale( 100,100 );
        clockCircle();

    }
    
    public CoolDown/*Ex*/( double secs, int r, int g, int b, int a, int AD ){
    
        R = r;
        G = g;
        B = b;
        A = a;
        ad = AD;
        incr = (double) 360 / Math.max( SEC2ACT( secs ), 1);
        interval = incr;
        getImage().scale( 100,100 );
        clockCircle();    
    
    }

    public void act() 
    {

        if( timer > 360 ){

            w.removeObject(this);
            return;

        }

        if ( incr < 1. ){

            incr += interval;
            return;

        }

        clockCircle();
        incr = interval;

    }

    private void clockCircle(){

        GreenfootImage img = getImage();
        img.clear();

        int[] x2 = new int[361],
        y2 = new int[361];
        int i = 0, 
        maior = (int) timer, 
        menor = 0;

        for ( int g = 0; g <= 40; g+=2){
            
            img.setColor( new Color( R, G, B, A-g*ad ) );
            
            for( int deg = 0; deg <= 360; deg += 5 ){
                
                if( deg < maior && deg > menor ) continue; 
    
                x2[i] = (int) ( 50 + g * Math.cos( Math.toRadians( deg ) ) );
                y2[i] = (int) ( 50 + g * Math.sin( Math.toRadians( deg ) ) );
                i++;
    
            }

            if ( timer > 1 ){
                
                x2[1] = 45;
                y2[1] = 50;
        
            }
            
            img.fillPolygon( x2, y2, i );
            i = 0;
            
        }    
        
        timer += incr;

    }
    
}

/*
function act takes nothing returns nothing

local integer x
local integer y
local integer i = 0

loop                
exitwhen i > 360

set x = R2I( 0 + 500 * Cos( i * bj_DEGTORAD ) )
set y = R2I( 0 + 500 * Sin( i * bj_DEGTORAD ) )
call DestroyEffect( AddSpecialEffect( "Abilities\\Spells\\Undead\\FrostNova\\FrostNovaTarget.mdl", x, y ) )

set i = i + 20
endloop

//constantes
// pi 3.14159
// rad2deg 180.0/PI
// deg2rad PI/180.0
 */
